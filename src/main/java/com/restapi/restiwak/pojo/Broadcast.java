package com.restapi.restiwak.pojo;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "broadcast")
@ToString
public class Broadcast {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_broadcast"
    )
    private Integer id;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;
    @Column(
            name = "informasi"
    )
    private String informasi;
    @Column(
            name = "link"
    )
    private String link;
}
