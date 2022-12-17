package br.com.ifce.template.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_group")
@Getter @Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_group_id")
    private Long id;

    @Column(name = "user_group_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "group_permission",
            joinColumns = { @JoinColumn(name = "user_group_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_permission_id") })
    private Set<Permission> permissions = new HashSet<>();
}
