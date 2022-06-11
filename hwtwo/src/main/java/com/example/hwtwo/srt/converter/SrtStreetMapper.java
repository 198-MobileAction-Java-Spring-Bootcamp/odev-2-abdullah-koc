package com.example.hwtwo.srt.converter;

import com.example.hwtwo.nbh.service.entityservice.NbhNeighborhoodEntityService;
import com.example.hwtwo.srt.dto.SrtStreetSaveDto;
import com.example.hwtwo.srt.entity.SrtStreet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class SrtStreetMapper {

    @Autowired
    NbhNeighborhoodEntityService nbhNeighborhoodEntityService;

    @Mapping(
            target = "nbhNeighborhood",
            expression = "java(nbhNeighborhoodEntityService.findByIdWithControl(srtStreetSaveDto.getNbhNeighborhoodId()))"
    )
    public abstract SrtStreet convertToSrtStreet(SrtStreetSaveDto srtStreetSaveDto);
}
