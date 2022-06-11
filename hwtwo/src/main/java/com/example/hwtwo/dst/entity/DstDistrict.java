package com.example.hwtwo.dst.entity;

import com.example.hwtwo.cty.entity.CtyCity;
import com.example.hwtwo.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DST_DISTRICT")
@Getter
@Setter
public class DstDistrict extends BaseEntity {
    @Id
    @SequenceGenerator(name = "DstDistrict", sequenceName = "DST_DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "DstDistrict")
    private Long id;

    @Column(name = "DISTRICT", length = 30)
    private String district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CTY_CITY")
    private CtyCity ctyCity;
}
