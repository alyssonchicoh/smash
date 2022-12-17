package br.com.ifce.template.controller.dto.permission;

import br.com.ifce.template.model.Group;
import br.com.ifce.template.model.Permission;
import br.com.ifce.template.model.enums.PermissionTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PermissionResponseDTO {

    private Long id;
    private String name;
    private PermissionTypeEnum type;

    public PermissionResponseDTO(Permission permission){
        this.id = permission.getId();
        this.name = permission.getName();
        this.type = permission.getType();
    }
}
