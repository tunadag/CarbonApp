package com.tunadag.dto.request;

import com.tunadag.repositories.entity.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WineCreateRequestDto {

    private ProductType productType;
    private int productionYear;
    private boolean imported;
    private String productionCountry;
    private double netPrice;
    private double vat;
    private double vatPrice;
    private String producerName;
    private String serieName;
    private String grapeType;
    private int vintageYear;
    private int volumeMl;
}