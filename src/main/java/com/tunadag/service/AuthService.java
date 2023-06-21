package com.tunadag.service;

import com.tunadag.configuration.jwt.JwtService;
import com.tunadag.constant.ROLE_CONSTANTS;
import com.tunadag.dto.request.LoginRequestDto;
import com.tunadag.dto.request.RegisterRequestDto;
import com.tunadag.dto.response.AuthenticationResponseDto;
import com.tunadag.exceptions.custom.RoleNotFoundException;
import com.tunadag.exceptions.custom.UserAlreadyExistsException;
import com.tunadag.repositories.UserRepository;
import com.tunadag.repositories.entity.Role;
import com.tunadag.repositories.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;



    public String register(RegisterRequestDto request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already registered.");
        }

        List<Role> roles = roleService.findRoles();
        Set<Role> userRoles = roles.stream().filter(role -> request.getRoles().contains(role.getRole())).collect(Collectors.toSet());
        if (userRoles.isEmpty()) {
            throw new RoleNotFoundException("Given roles not found.");
        }

        User auth = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .roles(userRoles)
                .build();
        if (roleService.userHasRole(auth, ROLE_CONSTANTS.ROLE_ADMIN))
            auth.setAuthorizedRole((ROLE_CONSTANTS.ROLE_ADMIN));
        else if (roleService.userHasRole(auth, ROLE_CONSTANTS.ROLE_MANAGER))
            auth.setAuthorizedRole((ROLE_CONSTANTS.ROLE_MANAGER));
        else if (roleService.userHasRole(auth, ROLE_CONSTANTS.ROLE_SALESPERSON))
            auth.setAuthorizedRole((ROLE_CONSTANTS.ROLE_SALESPERSON));
        else throw new RoleNotFoundException("Role is not found");

        userRepository.save(auth);

        return "Kayıt başarılı";
    }

    public AuthenticationResponseDto authenticate(LoginRequestDto request){
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Username does not exist.");
        }
        userRepository.save(user.get());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        return AuthenticationResponseDto.builder()
                .token(jwtService.generateToken(user.get()))
                .build();
    }
}
