package com.example.hwtwo.nbh.entity;

import com.example.hwtwo.dst.entity.DstDistrict;
import com.example.hwtwo.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "NBH_NEIGHBORHOOD")
@Getter
@Setter
public class NbhNeighborhood extends BaseEntity {
    @Id
    @SequenceGenerator(name = "NbhNeighborhood", sequenceName = "NBH_NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue(generator = "NbhNeighborhood")
    private Long id;

    @Column(name = "NEIGHBORHOOD", length = 30)
    private String neighborhood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DST_DISTRICT")
    private DstDistrict dstDistrict;
}
