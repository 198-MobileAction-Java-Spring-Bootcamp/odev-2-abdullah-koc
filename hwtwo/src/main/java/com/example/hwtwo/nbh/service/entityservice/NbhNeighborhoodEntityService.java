package com.example.hwtwo.nbh.service.entityservice;

import com.example.hwtwo.gen.service.BaseEntityService;
import com.example.hwtwo.nbh.dao.NbhNeighborhoodDao;
import com.example.hwtwo.nbh.entity.NbhNeighborhood;
import org.springframework.stereotype.Service;

@Service
public class NbhNeighborhoodEntityService extends BaseEntityService<NbhNeighborhood, NbhNeighborhoodDao> {
    public NbhNeighborhoodEntityService(NbhNeighborhoodDao dao) {
        super(dao);
    }
}
