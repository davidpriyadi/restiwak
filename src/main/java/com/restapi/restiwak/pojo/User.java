package com.restapi.restiwak.pojo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@ToString
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "userId"
    )
    private Long id;
    @Column(
            name = "nama"
    )
    private String nama;
    @Column(
            unique = true,
            name = "email"
    )
    private String email;
    @Column(
            name = "password"
    )
    private String password;
    @ManyToOne
    @JoinColumn(
            name = "idUserRole",
            nullable = false
    )
    private UserRole userRole;
}
