package com.tunadag.repositories.entity;

import java.util.ArrayList;
import java.util.List;

import com.tunadag.repositories.entity.base.BaseEntity;
import com.tunadag.repositories.entity.enums.Region;
import com.tunadag.repositories.entity.enums.SalespersonCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Salesperson extends BaseEntity {
    @NotNull
    @Enumerated(EnumType.STRING)
    private Region region;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private SalespersonCode salespersonCode;
    private String name;
    private String surName;
    @OneToMany
    @Builder.Default
    private List<Customer> customerList = new ArrayList<>();
}
