package com.example.hwtwo.dst.service.entityservice;

import com.example.hwtwo.dst.dao.DstDistrictDao;
import com.example.hwtwo.dst.entity.DstDistrict;
import com.example.hwtwo.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class DstDistrictEntityService extends BaseEntityService<DstDistrict, DstDistrictDao> {
    public DstDistrictEntityService(DstDistrictDao dao) {
        super(dao);
    }
}
