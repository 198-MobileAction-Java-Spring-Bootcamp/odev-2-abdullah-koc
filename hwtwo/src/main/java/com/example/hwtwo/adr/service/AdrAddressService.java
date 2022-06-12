package com.example.hwtwo.adr.service;

import com.example.hwtwo.adr.converter.AdrAddressConverter;
import com.example.hwtwo.adr.converter.AdrAddressSaveMapper;
import com.example.hwtwo.adr.dto.AdrAddressDto;
import com.example.hwtwo.adr.dto.AdrAddressSaveDto;
import com.example.hwtwo.adr.entity.AdrAddress;
import com.example.hwtwo.adr.service.entityservice.AdrAddressEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrAddressService {

    private final AdrAddressEntityService adrAddressEntityService;
    private final AdrAddressSaveMapper adrAddressSaveMapper;

    public List<AdrAddressDto> findAll(){
        List<AdrAddress> adrAddressList = adrAddressEntityService.findAll();
        List<AdrAddressDto> adrAddressDtoList = new ArrayList<>();
        for(int i = 0; i < adrAddressList.size(); i++){
            adrAddressDtoList.add(AdrAddressConverter.convertToAdrAddressDto(adrAddressList.get(i)));
        }
        return adrAddressDtoList;
    }

    /*
     * This method is used to save an address.
     * @param adrAddressSaveDto is the address that is going to be saved.
     * @return the address that is saved.
     */
    public AdrAddressDto save(AdrAddressSaveDto adrAddressSaveDto){
        AdrAddress adrAddress = adrAddressSaveMapper.convertToAdrAddress(adrAddressSaveDto);
        adrAddress.setDoorNumber(adrAddressSaveDto.getDoorNumber());
        adrAddress.setAptNumber(adrAddressSaveDto.getAptNumber());
        adrAddressEntityService.save(adrAddress);
        return AdrAddressConverter.convertToAdrAddressDto(adrAddress);
    }

    /*
     * This method is used to delete an address by its id.
     * @param id is the id of the address that is going to be deleted.
     */
    public void deleteAddress(Long id){
        if(!adrAddressEntityService.existsById(id)){
            throw new RuntimeException("Address does not exist with id: " + id);
        }
        adrAddressEntityService.delete(adrAddressEntityService.findByIdWithControl(id));
    }

    /*
     * This method is used to find an address by its id.
     * @param id is the id of the address that is going to be found.
     * @return the address that is found.
     * @throws RuntimeException if the address is not found.
     */
    public AdrAddressDto getAddressWithId(Long id){
        if(!adrAddressEntityService.existsById(id)){
            throw new RuntimeException("Address does not exist with id: " + id);
        }
        return AdrAddressConverter.convertToAdrAddressDto(adrAddressEntityService.findByIdWithControl(id));
    }
}
