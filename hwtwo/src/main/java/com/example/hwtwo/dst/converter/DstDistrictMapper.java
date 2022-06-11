package com.example.hwtwo.dst.converter;

import com.example.hwtwo.cty.service.entityservice.CtyCityEntityService;
import com.example.hwtwo.dst.dto.DstDistrictSaveDto;
import com.example.hwtwo.dst.entity.DstDistrict;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class DstDistrictMapper {

    @Autowired
    CtyCityEntityService ctyCityEntityService;

    @Mapping(
            target = "ctyCity",
            expression = "java(ctyCityEntityService.findByIdWithControl(dstDistrictSaveDto.getCtyCityId()))")
    public abstract DstDistrict convertToDstDistrict(DstDistrictSaveDto dstDistrictSaveDto);
}
