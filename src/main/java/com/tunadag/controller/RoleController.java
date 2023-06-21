package com.tunadag.controller;

import com.tunadag.dto.request.RoleCreateRequestDto;
import com.tunadag.dto.response.RoleCreateResponseDto;
import com.tunadag.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/createrole")
    public ResponseEntity<RoleCreateResponseDto> createRole(RoleCreateRequestDto dto) {
        return ResponseEntity.ok(roleService.createRole(dto));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/findroles")
    @Operation(summary = "Tüm rollerin görüntülenmesini sağlayan metot.")
    public ResponseEntity<List<String>> findRoles() {
        return ResponseEntity.ok(roleService.findRoleStrings());
    }
}