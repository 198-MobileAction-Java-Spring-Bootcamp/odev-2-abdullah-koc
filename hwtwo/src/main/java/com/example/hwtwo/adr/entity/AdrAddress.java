package com.example.hwtwo.adr.entity;

import com.example.hwtwo.cnt.entity.CntCountry;
import com.example.hwtwo.cty.entity.CtyCity;
import com.example.hwtwo.dst.entity.DstDistrict;
import com.example.hwtwo.gen.entity.BaseEntity;
import com.example.hwtwo.nbh.entity.NbhNeighborhood;
import com.example.hwtwo.srt.entity.SrtStreet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "ADR_ADDRESS")
@Getter
@Setter
public class AdrAddress extends BaseEntity {


    @Id
    @SequenceGenerator(name = "AdrAddress", sequenceName = "ADR_ADDRESS_ID_SEQ")
    @GeneratedValue(generator = "AdrAddress")
    private Long id;

    @Column(name = "DOOR_NUMBER", length = 10)
    private String doorNumber;

    @Column(name = "APT_NUMBER", length = 10)
    private String aptNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SRT_STREET")
    private SrtStreet srtStreet;
}
