package br.com.ifce.template.controller.dto.user;

import br.com.ifce.template.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
