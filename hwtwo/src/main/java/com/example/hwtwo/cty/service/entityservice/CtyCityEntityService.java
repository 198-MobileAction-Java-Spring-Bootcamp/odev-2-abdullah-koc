package com.example.hwtwo.cty.service.entityservice;

import com.example.hwtwo.cty.dao.CtyCityDao;
import com.example.hwtwo.cty.entity.CtyCity;
import com.example.hwtwo.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CtyCityEntityService extends BaseEntityService<CtyCity, CtyCityDao> {

    public CtyCityEntityService(CtyCityDao dao) {
        super(dao);
    }

    public CtyCity findByPlate(int plate){
        return getDao().findByPlate(plate);
    }
}
