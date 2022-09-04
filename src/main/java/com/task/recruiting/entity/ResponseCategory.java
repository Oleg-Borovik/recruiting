package com.task.recruiting.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Сущность таблицы response_category
 */
@Entity
@Data
@Table(name = "response_category")
public class ResponseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    private String category;
}
