package com.tunadag.repositories;

import com.tunadag.repositories.base.BaseRepository;
import com.tunadag.repositories.entity.Beer;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BeerRepository extends BaseRepository<Beer, Long> {
    Optional<Beer> findBeerByBrandNameAndSerieNameAndVolumeMl(String brandName, String serieName, int volumeMl);
}
