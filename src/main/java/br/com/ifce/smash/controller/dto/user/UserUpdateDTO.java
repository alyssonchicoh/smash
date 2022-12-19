package br.com.ifce.smash.controller.dto.user;

import br.com.ifce.smash.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor
public class UserUpdateDTO {

    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty
    private String login;

    @NotNull @NotEmpty @Email
    private String email;


    public User toUser(Long id){
        User user = new User();
        user.setId(id);
        user.setName(this.name);
        user.setLogin(this.login);
        user.setEmail(this.email);

        return user;
    }
}
