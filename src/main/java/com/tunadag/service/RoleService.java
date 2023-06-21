package com.tunadag.service;

import com.tunadag.dto.request.RoleCreateRequestDto;
import com.tunadag.dto.response.RoleCreateResponseDto;
import com.tunadag.repositories.RoleRepository;
import com.tunadag.repositories.entity.Role;
import com.tunadag.repositories.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public boolean userHasRole(User user, String role) {

        return user.getRoles().stream().map(Role::getRole)
                .anyMatch(roleString -> roleString.equals(role));
    }

    public boolean userHasAuthorizedRole(User user, String role) {

        return user.getAuthorizedRole().equals(role);
    }

    public boolean hasRole(String role) {

        return findRoleStrings().stream().anyMatch(roleString -> roleString.equals(role));
    }

    public List<String> findRoleStrings() {

        return roleRepository.findAllActive().stream().map(Role::getRole).collect(Collectors.toList());
    }

    public List<Role> findRoles() {

        return roleRepository.findAllActive();
    }

    public RoleCreateResponseDto createRole(RoleCreateRequestDto dto) {
        Role role = roleRepository.save(
                Role.builder()
                        .role(dto.getRole().toUpperCase())
                        .build()
        );

        return RoleCreateResponseDto.builder()
                .roleOid(role.getOid())
                .role(role.getRole())
                .build();
    }

    public Role findActiveRole(String role) {

        return roleRepository.findActiveRole(role);
    }

    public List<User> findUsersInRole(String role) {

        return roleRepository.findUsersWithRole(role);
    }

    public Role save(Role role) {

        return roleRepository.save(role);
    }
}
