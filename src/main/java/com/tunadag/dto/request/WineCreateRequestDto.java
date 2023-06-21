package com.tunadag.dto.request;

import com.tunadag.repositories.entity.enums.ProductType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WineCreateRequestDto {

    private ProductType productType;
    private int productionYear;
    private boolean imported;
    private String productionCountry;
    @NotNull
    private String producerName;
    @NotNull
    private String serieName;
    @NotNull
    private String grapeType;
    private int vintageYear;
    private int volumeMl;
}
