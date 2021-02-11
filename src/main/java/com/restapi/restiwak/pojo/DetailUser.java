package com.restapi.restiwak.pojo;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detail_user")
@ToString
public class DetailUser {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_detail_user"
    )
    private Integer id;
    @Column(
            name = "nik"
    )
    private String nik;
    @Column(
            name = "no_rumah"
    )
    private String noRumah;
    @Column(
            name = "jml_anggota_keluarga"
    )
    private String jmlAnggotaKeluarga;
    @Column(
            name = "no_hp"
    )
    private String noHp;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;
    @Column(
            name = "id_rt"
    )
    private String idRt;
}
