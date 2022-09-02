package com.task.recruiting.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "BlacklistFido")
public class BlacklistFido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fido")
    private String fido;
}
