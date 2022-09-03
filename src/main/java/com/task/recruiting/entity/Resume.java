package com.task.recruiting.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "\"users_skills\"",
            joinColumns = {@JoinColumn(name = "\"user_id\"")},
            inverseJoinColumns = {@JoinColumn(name = "\"skills_id\"")})
    private List<Skills> skills;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "\"category_user\"",
            joinColumns = {@JoinColumn(name = "\"user_id\"")},
            inverseJoinColumns = {@JoinColumn(name = "\"category_id\"")})
    private ResponseCategory responseCategory;

    public Resume() {
    }
}
