package com.task.recruiting.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "\"RESUME\"")
@AllArgsConstructor
@ToString
public class Resume {
    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "\"fido\"")
    @NotNull
    private String fido;

    @Column(name = "\"positions\"")
    @NotNull
    private String position;
    @Column(name = "\"previousPlace\"")
    private String previousPlace;

    @Column(name = "\"lvl\"")
    @NotNull
    private String level;

    @Column(name = "\"salary\"")
    @NotNull
    private Integer salary;

    @Column(name = "\"about\"")
    private String about;

    @ManyToMany
    @JoinTable(name = "\"users_skills\"",
            joinColumns = {@JoinColumn(name = "\"user_id\"")},
            inverseJoinColumns = {@JoinColumn(name = "\"skills_id\"")})
    private List<Skills> skills;

    @OneToOne
    private ResponseCategory responseCategory;

    public Resume() {
    }
}
