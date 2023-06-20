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
public class Wine extends Product {

    private String producerName;
    private String serieName;
    private String grapeType;
    private int vintageYear;
    private int volumeMl;
}
