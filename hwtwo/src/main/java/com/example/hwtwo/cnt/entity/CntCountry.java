package com.example.hwtwo.cnt.entity;

import com.example.hwtwo.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "CNT_COUNTRY")
@Getter
@Setter
public class CntCountry extends BaseEntity {

    @Id
    @SequenceGenerator(name = "CntCountry", sequenceName = "CNT_COUNTRY_ID_SEQ")
    @GeneratedValue(generator = "CntCountry")
    private Long id;

    @Column(name = "COUNTRY", length = 30)
    private String country;

    @Column(name = "COUNTRY_CODE", length = 10)
    private String countryCode;
}
