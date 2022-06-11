package com.example.hwtwo.cty.entity;

import com.example.hwtwo.cnt.entity.CntCountry;
import com.example.hwtwo.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "CTY_CITY")
@Getter
@Setter
public class CtyCity extends BaseEntity{

    @Id
    @SequenceGenerator(name = "CtyCity", sequenceName = "CTY_CITY_ID_SEQ")
    @GeneratedValue(generator = "CtyCity")
    private Long id;

    @Column(name = "CITY", length = 30)
    private String city;

    @Column(name = "PLATE")
    private int plate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CNT_COUNTRY")
    private CntCountry cntCountry;
}
