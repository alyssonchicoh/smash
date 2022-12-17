package br.com.ifce.template.service;

import br.com.ifce.template.model.Group;
import br.com.ifce.template.repository.GroupRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    @Transactional
    public Group save(Group group){
        return this.groupRepository.save(group);
    }

    public List<Group> search(){
        return this.groupRepository.findAll();
    }

    public Optional<Group> searchByID(Long id){
        return this.groupRepository.findById(id);
    }

    @Transactional
    public Optional<Group> update(Group newGroup){
        Optional<Group> oldGroup = this.searchByID(newGroup.getId());

        return oldGroup.isPresent()
                ? Optional.of(this.save(newGroup))
                : Optional.empty();
    }

    @Transactional
    public Boolean delete(Long id){
        Optional<Group> group = this.searchByID(id);

        if(group.isPresent()){
            this.groupRepository.delete(group.get());
            return true;
        }

        return false;
    }


}
