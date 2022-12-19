package br.com.ifce.smash.controller.dto.user;

import br.com.ifce.smash.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
        return new User(id,name,login,password,email,true,null);
    }
}
