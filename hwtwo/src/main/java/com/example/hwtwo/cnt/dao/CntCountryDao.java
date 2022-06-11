package com.example.hwtwo.cnt.dao;

import com.example.hwtwo.cnt.entity.CntCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CntCountryDao extends JpaRepository<CntCountry, Long> {

    public CntCountry findByCountryCode(String countryCode);
}
