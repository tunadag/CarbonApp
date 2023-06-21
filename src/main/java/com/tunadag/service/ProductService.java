package com.tunadag.service;

import com.tunadag.dto.request.BeerCreateRequestDto;
import com.tunadag.dto.request.WineCreateRequestDto;
import com.tunadag.mapper.ProductMapper;
import com.tunadag.repositories.BeerRepository;
import com.tunadag.repositories.WineRepository;
import com.tunadag.repositories.entity.Beer;
import com.tunadag.repositories.entity.Wine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final WineRepository wineRepository;
    private final BeerRepository beerRepository;
    public boolean createWine(WineCreateRequestDto dto) {
        if (wineRepository.findWineByProducerNameAndSerieNameAndAndGrapeTypeAndAndVintageYearAndVolumeMl(
                dto.getProducerName(), dto.getSerieName(), dto.getGrapeType(), dto.getVintageYear(), dto.getVolumeMl())
                .isPresent()) {
            throw new RuntimeException("This wine is already exists");
        }
        Wine wine = ProductMapper.INSTANCE.toWine(dto);
        wineRepository.save(wine);
        return true;
    }
    public boolean createBeer(BeerCreateRequestDto dto){
        if (beerRepository.findBeerByBrandNameAndSerieNameAndVolumeMl(
                dto.getBrandName(), dto.getSerieName(), dto.getVolumeMl()).isPresent()){
            throw new RuntimeException("This beer is already exists");
        }
        Beer beer = ProductMapper.INSTANCE.toBeer(dto);
        beerRepository.save(beer);
        return true;
    }
}
