package com.tunadag.repositories;

import com.tunadag.repositories.base.BaseRepository;
import com.tunadag.repositories.entity.Wine;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WineRepository extends BaseRepository<Wine, Long> {

    Optional<Wine> findWineByProducerNameAndSerieNameAndAndGrapeTypeAndAndVintageYearAndVolumeMl(String producerName,
                                                                                      String serieName,
                                                                                      String grapeType,
                                                                                      int vintageYear, int volumeMl);

}
