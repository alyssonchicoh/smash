package br.com.ifce.smash.controller.dto.permission;

import br.com.ifce.smash.model.Permission;
import br.com.ifce.smash.model.enums.PermissionTypeEnum;
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
