package com.example.hwtwo.adr.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdrAddressSaveDto {

    private Long srtStreetId;
    private String doorNumber;
    private String aptNumber;
}
