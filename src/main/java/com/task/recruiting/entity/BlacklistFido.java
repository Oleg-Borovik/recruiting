package com.task.recruiting.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Сущность таблицы blacklist_fido
 */
@Entity
@Data
@Table(name = "blacklist_fido")
public class BlacklistFido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fido")
    private String fido;
}
