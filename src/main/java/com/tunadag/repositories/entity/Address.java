package com.tunadag.repositories.entity;

import com.tunadag.repositories.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Address extends BaseEntity {
    @NotNull
    private String city;
    @NotNull
    private String district;
    private String neighborhood;
    private String street;
    @NotNull
    private int doorNumber;
}
