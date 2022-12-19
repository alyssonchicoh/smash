package br.com.ifce.smash.controller;

import br.com.ifce.smash.controller.dto.permission.PermissionRequestDTO;
import br.com.ifce.smash.controller.dto.permission.PermissionResponseDTO;
import br.com.ifce.smash.model.Permission;
import br.com.ifce.smash.service.PermissionService;
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
@RequestMapping("/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    @Autowired
    private PermissionController(PermissionService permissionService){
        this.permissionService = permissionService;
    }

    @GetMapping
    public List<PermissionResponseDTO> search(){
        return this.permissionService
                .search()
                .stream()
                .map(PermissionResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponseDTO> searchById(@PathVariable Long id) {
        Optional<Permission> permission = this.permissionService.searchByID(id);

        return permission.isPresent()
                ? ResponseEntity.ok(new PermissionResponseDTO(permission.get()))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PermissionResponseDTO> save(@RequestBody @Valid PermissionRequestDTO permissionRequestDTO, UriComponentsBuilder uriBuilder){
        Permission permission = permissionRequestDTO.toPermission();
        this.permissionService.save(permission);

        URI uri = uriBuilder.path("/groups/{id}").buildAndExpand(permission.getId()).toUri();
        return ResponseEntity.created(uri).body(new PermissionResponseDTO(permission));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponseDTO> update(@PathVariable Long id, @RequestBody @Valid PermissionRequestDTO permissionRequestDTO) {
        Optional<Permission> permission = this.permissionService.update(permissionRequestDTO.toPermission(id));

        return permission.isPresent()
                ? ResponseEntity.ok(new PermissionResponseDTO(permission.get()))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean removed = this.permissionService.delete(id);

        return removed
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();

    }
}
