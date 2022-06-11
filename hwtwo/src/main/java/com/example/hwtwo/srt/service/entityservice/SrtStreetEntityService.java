package com.example.hwtwo.srt.service.entityservice;


import com.example.hwtwo.gen.service.BaseEntityService;
import com.example.hwtwo.srt.dao.SrtStreetDao;
import com.example.hwtwo.srt.entity.SrtStreet;
import org.springframework.stereotype.Service;

@Service
public class SrtStreetEntityService extends BaseEntityService<SrtStreet, SrtStreetDao> {
    public SrtStreetEntityService(SrtStreetDao dao) {
        super(dao);
    }
}
