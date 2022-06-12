package com.example.hwtwo.adr.converter;


import com.example.hwtwo.adr.dto.AdrAddressSaveDto;
import com.example.hwtwo.adr.entity.AdrAddress;
import com.example.hwtwo.srt.service.entityservice.SrtStreetEntityService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class AdrAddressSaveMapper {

    @Autowired
    SrtStreetEntityService srtStreetEntityService;

    @Mapping(
            target = "srtStreet",
            expression = "java(srtStreetEntityService.findByIdWithControl(adrAddressSaveDto.getSrtStreetId()))")
    public abstract AdrAddress convertToAdrAddress(AdrAddressSaveDto adrAddressSaveDto);
}
