package com.example.hwtwo.adr.converter;

import com.example.hwtwo.adr.dto.AdrAddressDto;
import com.example.hwtwo.adr.dto.AdrAddressSaveDto;
import com.example.hwtwo.adr.entity.AdrAddress;
import com.example.hwtwo.cnt.entity.CntCountry;
import com.example.hwtwo.cty.entity.CtyCity;
import com.example.hwtwo.dst.entity.DstDistrict;
import com.example.hwtwo.nbh.entity.NbhNeighborhood;
import com.example.hwtwo.srt.entity.SrtStreet;
import com.example.hwtwo.srt.service.SrtStreetService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class AdrAddressConverter {

    private static SrtStreetService srtStreetService;

    public static AdrAddressDto convertToAdrAddressDto(AdrAddress adrAddress){

        AdrAddressDto adrAddressDto = new AdrAddressDto();
        SrtStreet srtStreet = adrAddress.getSrtStreet();
        NbhNeighborhood nbhNeighborhood = srtStreet.getNbhNeighborhood();
        DstDistrict dstDistrict = nbhNeighborhood.getDstDistrict();
        CtyCity ctyCity = dstDistrict.getCtyCity();
        CntCountry cntCountry = ctyCity.getCntCountry();

        adrAddressDto.setId(adrAddress.getId());
        adrAddressDto.setStreetName(srtStreet.getStreetName());
        adrAddressDto.setNeighborhoodName(nbhNeighborhood.getNeighborhood());
        adrAddressDto.setDistrictName(dstDistrict.getDistrict());
        adrAddressDto.setCityName(ctyCity.getCity());
        adrAddressDto.setCountryName(cntCountry.getCountry());
        adrAddressDto.setAptNumber(adrAddress.getAptNumber());
        adrAddressDto.setDoorNumber(adrAddress.getDoorNumber());
        adrAddressDto.setPlate(ctyCity.getPlate());

        return adrAddressDto;
    }
}
