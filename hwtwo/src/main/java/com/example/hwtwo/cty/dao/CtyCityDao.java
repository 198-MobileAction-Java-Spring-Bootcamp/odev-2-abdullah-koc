package com.example.hwtwo.cty.dao;

import com.example.hwtwo.cty.entity.CtyCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CtyCityDao extends JpaRepository<CtyCity, Long> {

    public CtyCity findByPlate(int plate);
}
