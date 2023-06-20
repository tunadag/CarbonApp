package com.tunadag.repositories.entity;

import com.tunadag.repositories.entity.base.BaseEntity;
import com.tunadag.repositories.entity.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class Product extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private int productionYear;
    private boolean imported;
    private String productionCountry;
}
