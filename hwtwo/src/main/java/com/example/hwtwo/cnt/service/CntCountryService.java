package com.example.hwtwo.cnt.service;


import com.example.hwtwo.cnt.entity.CntCountry;
import com.example.hwtwo.cnt.service.entityservice.CntCountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CntCountryService {

    private final CntCountryEntityService cntCountryEntityService;

    public List<CntCountry> findAll(){
        return cntCountryEntityService.findAll();
    }

    public CntCountry save(CntCountry cntCountry){

        cntCountryEntityService.save(cntCountry);
        return cntCountry;
    }

    public CntCountry findById(Long id){
        return cntCountryEntityService.findById(id).orElseThrow();
    }

    public CntCountry findByCountryCode(String countryCode){
        CntCountry cntCountry = cntCountryEntityService.findByCountryCode(countryCode);

        if(cntCountry == null){
            throw new RuntimeException("Country does not exist.");
        }
        return cntCountry;
    }
}
