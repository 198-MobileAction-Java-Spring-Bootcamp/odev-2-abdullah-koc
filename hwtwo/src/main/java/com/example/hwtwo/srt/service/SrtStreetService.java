package com.example.hwtwo.srt.service;


import com.example.hwtwo.nbh.dto.NbhNeighborhoodFindDto;
import com.example.hwtwo.nbh.entity.NbhNeighborhood;
import com.example.hwtwo.nbh.service.NbhNeighborhoodService;
import com.example.hwtwo.srt.converter.SrtStreetMapper;
import com.example.hwtwo.srt.dto.SrtStreetSaveDto;
import com.example.hwtwo.srt.entity.SrtStreet;
import com.example.hwtwo.srt.service.entityservice.SrtStreetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SrtStreetService {
    private final SrtStreetEntityService srtStreetEntityService;
    private final NbhNeighborhoodService nbhNeighborhoodService;
    private final SrtStreetMapper srtStreetMapper;

    public List<SrtStreet> findAll(){
        return srtStreetEntityService.findAll();
    }

    //Finding street by id
    public SrtStreet findById(Long id){
        return srtStreetEntityService.findById(id).orElseThrow();
    }

    //Saving a street
    public SrtStreet save(SrtStreetSaveDto srtStreetSaveDto){
        SrtStreet srtStreet = srtStreetMapper.convertToSrtStreet(srtStreetSaveDto);
        srtStreet = srtStreetEntityService.save(srtStreet);
        return srtStreet;
    }

    //Updating street name
    public SrtStreet updateName(SrtStreet srtStreet){
        if(!srtStreetEntityService.existsById(srtStreet.getId())){
            throw new RuntimeException("This street does not exist.");
        }
        return srtStreetEntityService.save(srtStreet);
    }

    //Finding all streets of a neighborhood
    public List<SrtStreet> findByNeighborhood(NbhNeighborhoodFindDto nbhNeighborhoodFindDto){

        NbhNeighborhood nbhNeighborhood = nbhNeighborhoodService.findById(nbhNeighborhoodFindDto.getId());
        if(!nbhNeighborhood.getNeighborhood().equals(nbhNeighborhoodFindDto.getNeighborhoodName())){
            throw new RuntimeException("Neighborhood name does not match.");
        }

        List<SrtStreet> allStreets = srtStreetEntityService.findAll();
        List<SrtStreet> result = new ArrayList<>();
        for(int i = 0; i < allStreets.size(); i++){
            if(allStreets.get(i).getNbhNeighborhood().getId() == nbhNeighborhoodFindDto.getId()){
                result.add(allStreets.get(i));
            }
        }
        return result;
    }
}
