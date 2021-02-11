package com.restapi.restiwak.pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jenis_iuran")
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class JenisIuran {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_jenis_iuran"
    )
    private int id;
    @Column(
            name = "nama_iuran"
    )
    private String namaIuran;
    @Column(
            name = "nominal"
    )
    private int nominal;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;
    @ManyToMany(
            mappedBy = "jenisIurans",
            cascade = {CascadeType.ALL},
            targetEntity = IuranPerbulan.class
    )
    private List<IuranPerbulan> iuranPerbulans;
}
