package com.example.hwtwo.cnt.service.entityservice;


import com.example.hwtwo.cnt.dao.CntCountryDao;
import com.example.hwtwo.cnt.entity.CntCountry;
import com.example.hwtwo.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CntCountryEntityService extends BaseEntityService<CntCountry, CntCountryDao> {
    public CntCountryEntityService(CntCountryDao dao) {
        super(dao);
    }

    public CntCountry findByCountryCode(String countryCode){
        return getDao().findByCountryCode(countryCode);
    }
}
