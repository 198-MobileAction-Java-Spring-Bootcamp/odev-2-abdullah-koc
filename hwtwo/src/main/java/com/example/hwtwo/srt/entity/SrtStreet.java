package com.example.hwtwo.srt.entity;

import com.example.hwtwo.gen.entity.BaseEntity;
import com.example.hwtwo.nbh.entity.NbhNeighborhood;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SRT_STREET")
@Getter
@Setter
public class SrtStreet extends BaseEntity {

    @Id
    @SequenceGenerator(name = "SrtStreet", sequenceName = "SRT_STREET_ID_SEQ")
    @GeneratedValue(generator = "SrtStreet")
    private Long id;

    @Column(name = "STREET_NAME", length = 30)
    private String streetName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NBH_NEIGHBORHOOD")
    private NbhNeighborhood nbhNeighborhood;
}
