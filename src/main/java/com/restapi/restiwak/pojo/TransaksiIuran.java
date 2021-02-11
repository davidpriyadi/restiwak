package com.restapi.restiwak.pojo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaksi_iuran")
@ToString
public class TransaksiIuran {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_transaksi"
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
    @ManyToOne
    @JoinColumn(
            name = "id_iuran_perbulan",
            nullable = false
    )
    private IuranPerbulan iuranPerbulan;
    @Column(
            name = "tanggal_bayar"
    )
    private LocalDate tanggalBayar;
    @Column(
            name = "idrt"
    )
    private String idRt;
    @Column(
            name = "active"
    )
    private Boolean active;

}
