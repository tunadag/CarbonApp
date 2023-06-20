package com.tunadag.repositories.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tunadag.repositories.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table
public class Role extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String role;
    @JsonBackReference
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
