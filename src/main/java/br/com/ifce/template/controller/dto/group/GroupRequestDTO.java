package br.com.ifce.template.controller.dto.group;

import br.com.ifce.template.model.Group;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupRequestDTO {

    @NotEmpty @NotEmpty
    private String name;

    public Group toGroup(){
        Group group = new Group();
        group.setName(name);

        return group;
    }

    public Group toGroup(Long id){
        Group group = new Group();
        group.setId(id);
        group.setName(name);

        return group;
    }
}
