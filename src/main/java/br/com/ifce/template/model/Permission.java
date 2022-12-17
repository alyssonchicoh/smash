package br.com.ifce.template.model;

import br.com.ifce.template.model.enums.PermissionTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "user_permission")
@Getter @Setter
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_permission_id")
    private Long id;

    @Column(name = "user_permission_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_permission_type")
    private PermissionTypeEnum type;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE },
            mappedBy = "permissions"
    )
    @JsonIgnore
    private Set<Group> userGroups;
}
