package com.example.hwtwo.dst.service;


import com.example.hwtwo.cty.dto.CtyCityFindDto;
import com.example.hwtwo.cty.entity.CtyCity;
import com.example.hwtwo.cty.service.CtyCityService;
import com.example.hwtwo.dst.converter.DstDistrictMapper;
import com.example.hwtwo.dst.dto.DstDistrictSaveDto;
import com.example.hwtwo.dst.entity.DstDistrict;
import com.example.hwtwo.dst.service.entityservice.DstDistrictEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DstDistrictService {
    private final DstDistrictEntityService dstDistrictEntityService;
    private final DstDistrictMapper dstDistrictMapper;

    public List<DstDistrict> findAll(){
        return dstDistrictEntityService.findAll();
    }

    //Finding a district by its id
    public DstDistrict findById(Long id) {
        return dstDistrictEntityService.findById(id).orElseThrow();
    }

    //Saving a district
    public DstDistrict save(DstDistrictSaveDto dstDistrictSaveDto){

        DstDistrict dstDistrict = dstDistrictMapper.convertToDstDistrict(dstDistrictSaveDto);
        dstDistrict = dstDistrictEntityService.save(dstDistrict);
        return dstDistrict;
    }

    //Finding districts of a city
    public List<DstDistrict> findDistrictsOfCity(CtyCityFindDto ctyCityFindDto){

        List<DstDistrict> districts = findAll();

        List<DstDistrict> list = new ArrayList<>();

        for(int i = 0; i < districts.size(); i++){
            if(districts.get(i).getCtyCity().getPlate() == ctyCityFindDto.getPlate()){
                list.add(districts.get(i));
            }
        }
        return list;
    }


}
