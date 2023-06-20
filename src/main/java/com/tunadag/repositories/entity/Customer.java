package com.tunadag.repositories.entity;

import com.tunadag.repositories.entity.base.BaseEntity;
import com.tunadag.repositories.entity.enums.CustomerType;
import com.tunadag.repositories.entity.enums.Region;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Customer extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
    private String customerCode;
    private String tableName;
    private String companyName;
    private Region region;
    private String address;
}
