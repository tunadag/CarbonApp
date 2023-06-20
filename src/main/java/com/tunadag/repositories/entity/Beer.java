package com.tunadag.repositories.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table
public class Beer extends Product {

    private String brandName;
    private String serieName;
    private int unitsPerBox;
}
