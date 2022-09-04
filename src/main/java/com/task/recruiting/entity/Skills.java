package com.task.recruiting.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
/**
 * Сущность таблицы skills
 */
@Entity
@Data
@Table(name = "skills")
@ToString
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "skill")
    private String skill;

}
