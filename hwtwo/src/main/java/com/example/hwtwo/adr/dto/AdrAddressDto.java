package com.example.hwtwo.adr.dto;

import lombok.Data;

@Data
public class AdrAddressDto {
    private Long id;
    private String countryName;
    private String cityName;
    private int plate;
    private String districtName;
    private String neighborhoodName;
    private String streetName;
    private String doorNumber;
    private String aptNumber;
}
