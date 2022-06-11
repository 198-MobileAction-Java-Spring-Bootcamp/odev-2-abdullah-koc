package com.example.hwtwo.adr.converter;


import com.example.hwtwo.adr.dto.AdrAddressSaveDto;
import com.example.hwtwo.adr.entity.AdrAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrAddressSaveMapper {
    AdrAddressSaveMapper INSTANCE = Mappers.getMapper(AdrAddressSaveMapper.class);

    @Mapping(target = "srtStreet.id", source = "srtStreetId")
    AdrAddress convertToAdrAddress(AdrAddressSaveDto adrAddressSaveDto);
}
