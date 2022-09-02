package com.task.recruiting.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "responseCategory")
public class ResponseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    private String category;
}
