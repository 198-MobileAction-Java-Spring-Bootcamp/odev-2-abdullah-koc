package com.example.hwtwo.adr.service;

import com.example.hwtwo.adr.converter.AdrAddressConverter;
import com.example.hwtwo.adr.converter.AdrAddressSaveMapper;
import com.example.hwtwo.adr.dto.AdrAddressDto;
import com.example.hwtwo.adr.dto.AdrAddressSaveDto;
import com.example.hwtwo.adr.entity.AdrAddress;
import com.example.hwtwo.adr.service.entityservice.AdrAddressEntityService;
import com.example.hwtwo.srt.entity.SrtStreet;
import com.example.hwtwo.srt.service.SrtStreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrAddressService {

    private final AdrAddressEntityService adrAddressEntityService;
    private final SrtStreetService srtStreetService;

    public List<AdrAddressDto> findAll(){
        List<AdrAddress> adrAddressList = adrAddressEntityService.findAll();
        List<AdrAddressDto> adrAddressDtoList = new ArrayList<>();
        for(int i = 0; i < adrAddressList.size(); i++){
            adrAddressDtoList.add(AdrAddressConverter.convertToAdrAddressDto(adrAddressList.get(i)));
        }
        return adrAddressDtoList;
    }

    public AdrAddressDto save(AdrAddressSaveDto adrAddressSaveDto){
        SrtStreet srtStreet = srtStreetService.findById(adrAddressSaveDto.getSrtStreetId());
        AdrAddress adrAddress = new AdrAddress();
        adrAddress.setDoorNumber(adrAddressSaveDto.getDoorNumber());
        adrAddress.setAptNumber(adrAddressSaveDto.getAptNumber());
        adrAddress.setSrtStreet(srtStreet);
        adrAddressEntityService.save(adrAddress);
        return AdrAddressConverter.convertToAdrAddressDto(adrAddress);
    }

    public void deleteAddress(Long id){
        if(!adrAddressEntityService.existsById(id)){
            throw new RuntimeException("Address does not exist with id: " + id);
        }
        adrAddressEntityService.delete(adrAddressEntityService.findByIdWithControl(id));
    }

    public AdrAddressDto getAddressWithId(Long id){
        if(!adrAddressEntityService.existsById(id)){
            throw new RuntimeException("Address does not exist with id: " + id);
        }
        return AdrAddressConverter.convertToAdrAddressDto(adrAddressEntityService.findByIdWithControl(id));
    }
}
