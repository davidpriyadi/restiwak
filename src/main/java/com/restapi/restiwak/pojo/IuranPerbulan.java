package com.restapi.restiwak.pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "iuran_perbulan")
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class IuranPerbulan {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_iuran_perbulan"
    )
    private Integer id;
    @Column(
            name = "tanggal_iuran"
    )
    private LocalDate tanggalIuran;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;
    @ManyToMany(
            cascade = {CascadeType.ALL},
            targetEntity = JenisIuran.class
    )
    @JoinTable(
            name = "detil_iuran",
            joinColumns = {@JoinColumn(
                    name = "id_iuran_perbulan"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "id_jenis_iuran"
            )}
    )
    private List<JenisIuran> jenisIurans;
}
