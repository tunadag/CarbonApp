package com.tunadag.repositories;

import com.tunadag.repositories.base.BaseRepository;
import com.tunadag.repositories.entity.Salesperson;
import org.springframework.stereotype.Repository;

@Repository
public interface SalespersonRepository extends BaseRepository<Salesperson, Long> {
}
