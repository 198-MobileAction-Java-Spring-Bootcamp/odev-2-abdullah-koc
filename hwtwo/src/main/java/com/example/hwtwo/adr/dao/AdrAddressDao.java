package com.example.hwtwo.adr.dao;

import com.example.hwtwo.adr.entity.AdrAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrAddressDao extends JpaRepository<AdrAddress, Long> {
}
