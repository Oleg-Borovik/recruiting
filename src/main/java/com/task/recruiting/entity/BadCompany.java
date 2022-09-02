package com.task.recruiting.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "BadCompany")
public class BadCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nameCompany")
    private String nameCompany;
}
