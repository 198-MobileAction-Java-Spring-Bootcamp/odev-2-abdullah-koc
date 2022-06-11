package com.example.hwtwo.cty.service;


import com.example.hwtwo.cnt.service.CntCountryService;
import com.example.hwtwo.cty.converter.CtyCityMapper;
import com.example.hwtwo.cty.dto.CtyCitySaveDto;
import com.example.hwtwo.cty.entity.CtyCity;
import com.example.hwtwo.cty.service.entityservice.CtyCityEntityService;
import com.example.hwtwo.dst.entity.DstDistrict;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CtyCityService {

    private final CtyCityEntityService ctyCityEntityService;
    private final CtyCityMapper ctyCityMapper;

    public List<CtyCity> findAll(){
        return ctyCityEntityService.findAll();
    }

    public CtyCity save(CtyCitySaveDto ctyCitySaveDto){
        CtyCity ctyCity = ctyCityMapper.convertToCtyCity(ctyCitySaveDto);
        ctyCityEntityService.save(ctyCity);
        return ctyCity;
    }

    public CtyCity findById(Long id){
        return ctyCityEntityService.findById(id).orElseThrow();
    }

    public CtyCity findByPlate(int plate){
        CtyCity ctyCity = ctyCityEntityService.findByPlate(plate);
        if(ctyCity == null){
            throw new RuntimeException("City does not exist.");
        }
        return ctyCity;
    }
}
