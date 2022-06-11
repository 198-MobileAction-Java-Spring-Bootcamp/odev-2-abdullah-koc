package com.example.hwtwo.adr.controller;


import com.example.hwtwo.adr.dto.AdrAddressDto;
import com.example.hwtwo.adr.dto.AdrAddressSaveDto;
import com.example.hwtwo.adr.service.AdrAddressService;
import com.example.hwtwo.cnt.entity.CntCountry;
import com.example.hwtwo.cnt.service.CntCountryService;
import com.example.hwtwo.cty.dto.CtyCityFindDto;
import com.example.hwtwo.cty.dto.CtyCitySaveDto;
import com.example.hwtwo.cty.entity.CtyCity;
import com.example.hwtwo.cty.service.CtyCityService;
import com.example.hwtwo.dst.dto.DstDistrictFindDto;
import com.example.hwtwo.dst.dto.DstDistrictSaveDto;
import com.example.hwtwo.dst.entity.DstDistrict;
import com.example.hwtwo.dst.service.DstDistrictService;
import com.example.hwtwo.nbh.dto.NbhNeighborhoodFindDto;
import com.example.hwtwo.nbh.dto.NbhNeighborhoodSaveDto;
import com.example.hwtwo.nbh.entity.NbhNeighborhood;
import com.example.hwtwo.nbh.service.NbhNeighborhoodService;
import com.example.hwtwo.srt.dto.SrtStreetSaveDto;
import com.example.hwtwo.srt.entity.SrtStreet;
import com.example.hwtwo.srt.service.SrtStreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AdrAddressController {

    private final CntCountryService cntCountryService;
    private final CtyCityService ctyCityService;
    private final DstDistrictService dstDistrictService;
    private final NbhNeighborhoodService nbhNeighborhoodService;
    private final SrtStreetService srtStreetService;
    private final AdrAddressService adrAddressService;

    @PostMapping("/country")
    public ResponseEntity saveCountry(@RequestBody CntCountry cntCountry){
        return ResponseEntity.ok(cntCountryService.save(cntCountry));
    }

    @GetMapping("/country/{countryCode}")
    public ResponseEntity findCountryByCountryCode(@PathVariable String countryCode){
        return ResponseEntity.ok(cntCountryService.findByCountryCode(countryCode));
    }

    @PostMapping("/city")
    public ResponseEntity saveCity(@RequestBody CtyCitySaveDto city){
        return ResponseEntity.ok(ctyCityService.save(city));
    }

    @GetMapping("/city/{plate}")
    public ResponseEntity findCityByPlate(@PathVariable int plate){
        return ResponseEntity.ok(ctyCityService.findByPlate(plate));
    }

    @PostMapping("/district")
    public ResponseEntity saveDistrict(@RequestBody DstDistrictSaveDto dstDistrictSaveDto){
        return ResponseEntity.ok(dstDistrictService.save(dstDistrictSaveDto));
    }

    @GetMapping("/district/by_city")
    public ResponseEntity<List<DstDistrict>> findDistrictsByCity(@RequestBody CtyCityFindDto ctyCityFindDto){
        return ResponseEntity.ok(dstDistrictService.findDistrictsOfCity(ctyCityFindDto));
    }

    @PostMapping("/neighborhood")
    public ResponseEntity saveNeighborhood(@RequestBody NbhNeighborhoodSaveDto nbhNeighborhoodSaveDto){
        return ResponseEntity.ok(nbhNeighborhoodService.save(nbhNeighborhoodSaveDto));
    }

    @PutMapping("/neighborhood/{id}/{name}")
    public ResponseEntity updateNeighborhoodName(@PathVariable Long id, @PathVariable String name){
        NbhNeighborhood nbhNeighborhood = nbhNeighborhoodService.findById(id);
        nbhNeighborhood.setNeighborhood(name);
        return ResponseEntity.ok(nbhNeighborhoodService.updateName(nbhNeighborhood));
    }

    @GetMapping("/neighborhood/by_district")
    public ResponseEntity<List<NbhNeighborhood>> findNeighborhoodsByDistrict(@RequestBody DstDistrictFindDto dstDistrictFindDto){
        return ResponseEntity.ok(nbhNeighborhoodService.findbyDistrict(dstDistrictFindDto));
    }

    @PostMapping("/street")
    public ResponseEntity saveStreet(@RequestBody SrtStreetSaveDto srtStreetSaveDto){
        return ResponseEntity.ok(srtStreetService.save(srtStreetSaveDto));
    }

    @PutMapping("/street/{id}/{name}")
    public ResponseEntity updateStreetName(@PathVariable Long id, @PathVariable String name){
        SrtStreet srtStreet = srtStreetService.findById(id);
        srtStreet.setStreetName(name);
        return ResponseEntity.ok(srtStreetService.updateName(srtStreet));
    }

    @GetMapping("/street/by_neighborhood")
    public ResponseEntity<List<SrtStreet>> findStreetsByNeighborhood(@RequestBody NbhNeighborhoodFindDto nbhNeighborhoodFindDto){
        return ResponseEntity.ok(srtStreetService.findByNeighborhood(nbhNeighborhoodFindDto));
    }

    @PostMapping
    public ResponseEntity saveAddress(@RequestBody AdrAddressSaveDto adrAddressSaveDto){
        return ResponseEntity.ok(adrAddressService.save(adrAddressSaveDto));
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id){
        adrAddressService.deleteAddress(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAddressById(@PathVariable Long id){
        return ResponseEntity.ok(adrAddressService.getAddressWithId(id));
    }


}
