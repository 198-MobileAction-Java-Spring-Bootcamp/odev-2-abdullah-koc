package com.example.hwtwo.adr.service.entityservice;

import com.example.hwtwo.adr.dao.AdrAddressDao;
import com.example.hwtwo.adr.entity.AdrAddress;
import com.example.hwtwo.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AdrAddressEntityService extends BaseEntityService<AdrAddress, AdrAddressDao> {
    public AdrAddressEntityService(AdrAddressDao dao) {
        super(dao);
    }
}
