package br.com.ifce.smash.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;
    @Column(name = "user_login", unique = true)
    private String login;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_email", unique = true)
    private String email;

    @Column(name = "user_active")
    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Permission> permission;


    public User(String name,String login,String password,String email,Boolean active){
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.active = active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permission;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
