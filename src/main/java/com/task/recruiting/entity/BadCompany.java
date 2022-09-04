package com.task.recruiting.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Сущность таблицы bad_company
 */
@Entity
@Data
@Table(name = "bad_company")
public class BadCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nameCompany")
    private String nameCompany;
}
