package com.tunadag.dto.response;

import lombok.*;

/**
 * @author Eralp Nitelik
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleCreateResponseDto {
    private Long roleOid;
    private String role;
}
