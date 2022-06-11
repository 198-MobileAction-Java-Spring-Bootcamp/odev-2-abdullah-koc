package com.example.hwtwo.cty.converter;

import com.example.hwtwo.cnt.service.entityservice.CntCountryEntityService;
import com.example.hwtwo.cty.dto.CtyCitySaveDto;
import com.example.hwtwo.cty.entity.CtyCity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class CtyCityMapper {

    @Autowired
    CntCountryEntityService cntCountryEntityService;


    @Mapping(
            target = "cntCountry",
            expression = "java(cntCountryEntityService.findByIdWithControl(ctyCitySaveDto.getCntCountryId()))")
    public abstract CtyCity convertToCtyCity(CtyCitySaveDto ctyCitySaveDto);
}
