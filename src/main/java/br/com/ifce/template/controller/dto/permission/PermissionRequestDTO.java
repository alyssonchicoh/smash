package br.com.ifce.template.controller.dto.permission;

import br.com.ifce.template.model.Group;
import br.com.ifce.template.model.Permission;
import br.com.ifce.template.model.enums.PermissionTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PermissionRequestDTO {

    @NotEmpty @NotNull
    private String name;
    @NotEmpty @NotNull
    private PermissionTypeEnum type;

    public Permission toPermission(){
        Permission permission = new Permission();
        permission.setName(this.name);
        permission.setType(this.type);

        return permission;
    }

    public Permission toPermission(Long id){
        Permission permission = new Permission();
        permission.setId(id);
        permission.setName(this.name);
        permission.setType(this.type);

        return permission;
    }
}
