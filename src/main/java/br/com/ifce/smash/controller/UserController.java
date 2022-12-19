package br.com.ifce.smash.controller;

import br.com.ifce.smash.controller.dto.user.UserRequestDTO;
import br.com.ifce.smash.controller.dto.user.UserResponseDTO;
import br.com.ifce.smash.controller.dto.user.UserUpdateDTO;
import br.com.ifce.smash.model.User;
import br.com.ifce.smash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> search(){
        return this.userService
                .search()
                .stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> searchById(@PathVariable Long id) {
        Optional<User> user = this.userService.searchByID(id);

        return user.isPresent()
                ? ResponseEntity.ok(new UserResponseDTO(user.get()))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@RequestBody @Valid UserRequestDTO userRequest, UriComponentsBuilder uriBuilder){
        User user = userRequest.toUser();
        this.userService.save(user);

        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserResponseDTO(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO userUpdateDTO) {
        Optional<User> user = this.userService.update(userUpdateDTO.toUser(id));

        return user.isPresent()
                ? ResponseEntity.ok(new UserResponseDTO(user.get()))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean removed = this.userService.delete(id);

        return removed
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();

    }

}
