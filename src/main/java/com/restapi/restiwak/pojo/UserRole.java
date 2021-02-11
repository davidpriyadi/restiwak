package com.restapi.restiwak.pojo;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_role")
@ToString
public class UserRole {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idUserRole"
    )
    private Integer idUserRole;
    @Column(
            name = "namaRole"
    )
    private String namaRole;


}
