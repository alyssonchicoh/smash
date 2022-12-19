package br.com.ifce.smash.controller.dto.user;

import br.com.ifce.smash.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDTO {

    private Long id;
    private String name;
    private String login;
    private String email;
    private Boolean active;

    public UserResponseDTO(){

    }

    public UserResponseDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.active = user.getActive();
    }

}
