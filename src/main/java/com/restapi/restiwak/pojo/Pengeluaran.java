package com.restapi.restiwak.pojo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pengeluaran")
@ToString
public class Pengeluaran {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_pengeluaran"
    )
    private Integer id;
    @Column(
            name = "nama_pengeluaran"
    )
    private String namaPengeluaran;
    @Column(
            name = "tanggal_pengeluaran"
    )
    private LocalDate tanggalPengeluaran;
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
}
