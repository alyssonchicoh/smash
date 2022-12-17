package br.com.ifce.template.controller;

import br.com.ifce.template.controller.dto.group.GroupRequestDTO;
import br.com.ifce.template.controller.dto.group.GroupResponseDTO;
import br.com.ifce.template.controller.dto.group.GroupUpdateDTO;
import br.com.ifce.template.model.Group;
import br.com.ifce.template.service.GroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    private GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupResponseDTO> search(){
        return this.groupService
                .search()
                .stream()
                .map(GroupResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupResponseDTO> searchById(@PathVariable Long id) {
        Optional<Group> group = this.groupService.searchByID(id);

        return group.isPresent()
                ? ResponseEntity.ok(new GroupResponseDTO(group.get()))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<GroupResponseDTO> save(@RequestBody @Valid GroupRequestDTO groupRequestDTO, UriComponentsBuilder uriBuilder){
        Group group = groupRequestDTO.toGroup();
        this.groupService.save(group);

        URI uri = uriBuilder.path("/groups/{id}").buildAndExpand(group.getId()).toUri();
        return ResponseEntity.created(uri).body(new GroupResponseDTO(group));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupResponseDTO> update(@PathVariable Long id, @RequestBody @Valid GroupUpdateDTO groupUpdateDTO) {
        Optional<Group> group = this.groupService.update(groupUpdateDTO.toGroup(id));

        return group.isPresent()
                ? ResponseEntity.ok(new GroupResponseDTO(group.get()))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean removed = this.groupService.delete(id);

        return removed
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();

    }
}
