package br.com.ifce.template.controller.dto.group;

import br.com.ifce.template.model.Group;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupResponseDTO {

    private Long id;
    private String name;

    public GroupResponseDTO(Group group){
        this.id = group.getId();
        this.name = group.getName();
    }
}
