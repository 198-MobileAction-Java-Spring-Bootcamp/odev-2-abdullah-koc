package com.example.hwtwo.nbh.converter;

import com.example.hwtwo.dst.service.entityservice.DstDistrictEntityService;
import com.example.hwtwo.nbh.dto.NbhNeighborhoodSaveDto;
import com.example.hwtwo.nbh.entity.NbhNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class NbhNeighborhoodMapper {

    @Autowired
    DstDistrictEntityService dstDistrictEntityService;

    @Mapping(
            target = "dstDistrict",
            expression = "java(dstDistrictEntityService.findByIdWithControl(nbhNeighborhoodSaveDto.getDstDistrictId()))")
    public abstract NbhNeighborhood convertToNbhNeighborhood(NbhNeighborhoodSaveDto nbhNeighborhoodSaveDto);
}
