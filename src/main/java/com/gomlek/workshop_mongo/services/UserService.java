package com.gomlek.workshop_mongo.services;

import com.gomlek.workshop_mongo.domain.User;
import com.gomlek.workshop_mongo.dto.UserDTO;
import com.gomlek.workshop_mongo.repository.UserRepository;
import com.gomlek.workshop_mongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll (){
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDto(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getNome(), objDto.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }
}
