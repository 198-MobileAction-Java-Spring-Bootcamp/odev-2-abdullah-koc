package com.example.hwtwo.nbh.service;


import com.example.hwtwo.dst.dto.DstDistrictFindDto;
import com.example.hwtwo.dst.entity.DstDistrict;
import com.example.hwtwo.dst.service.DstDistrictService;
import com.example.hwtwo.nbh.converter.NbhNeighborhoodMapper;
import com.example.hwtwo.nbh.dto.NbhNeighborhoodSaveDto;
import com.example.hwtwo.nbh.entity.NbhNeighborhood;
import com.example.hwtwo.nbh.service.entityservice.NbhNeighborhoodEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NbhNeighborhoodService {
    private final NbhNeighborhoodEntityService nbhNeighborhoodEntityService;
    private final DstDistrictService dstDistrictService;
    private final NbhNeighborhoodMapper nbhNeighborhoodMapper;

    public List<NbhNeighborhood> findAll(){
        return nbhNeighborhoodEntityService.findAll();
    }

    //Finding a neighborhood by its id
    public NbhNeighborhood findById(Long id){
        return nbhNeighborhoodEntityService.findById(id).orElseThrow();
    }

    //Saving a neighborhood
    public NbhNeighborhood save(NbhNeighborhoodSaveDto nbhNeighborhoodSaveDto){

        NbhNeighborhood nbhNeighborhood = nbhNeighborhoodMapper.convertToNbhNeighborhood(nbhNeighborhoodSaveDto);
        nbhNeighborhood = nbhNeighborhoodEntityService.save(nbhNeighborhood);
        return nbhNeighborhood;
    }

    //Updating neighborhood name
    public NbhNeighborhood updateName(NbhNeighborhood nbhNeighborhood){
        if(!nbhNeighborhoodEntityService.existsById(nbhNeighborhood.getId())){
            throw new RuntimeException("This neighborhood does not exist.");
        }
        return nbhNeighborhoodEntityService.save(nbhNeighborhood);
    }

    //Finding all neighborhoods in a district
    public List<NbhNeighborhood> findbyDistrict(DstDistrictFindDto dstDistrictFindDto){
        if(dstDistrictService.findById(dstDistrictFindDto.getDstDistrictId()) == null){
            throw new RuntimeException("District does not exist.");
        }
        else if(dstDistrictService.findById(dstDistrictFindDto.getDstDistrictId()) != null
        && !dstDistrictService.findById(dstDistrictFindDto.getDstDistrictId()).getDistrict().equals(dstDistrictFindDto.getDistrictName())){
            throw new RuntimeException("Name and id does not match.");
        }
        List<NbhNeighborhood> allNeighborhoods = nbhNeighborhoodEntityService.findAll();
        List<NbhNeighborhood> result = new ArrayList<>();
        for(int i = 0; i < allNeighborhoods.size(); i++){
            if(allNeighborhoods.get(i).getDstDistrict().getId() == dstDistrictFindDto.getDstDistrictId()){
                result.add(allNeighborhoods.get(i));
            }
        }
        return result;
    }
}
