package br.com.ifce.template.controller.dto.user;

import br.com.ifce.template.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserRequestDTO {

    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String login;
    @NotNull @NotEmpty
    private String password;
    @NotNull @NotEmpty @Email
    private String email;

    public User toUser(){
        return new User(name,login,password,email,true);
    }

    public User toUser(Long id){
        return new User(id,name,login,password,email,true);
    }
}
