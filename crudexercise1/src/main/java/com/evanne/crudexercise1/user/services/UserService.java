package com.evanne.crudexercise1.user.services;

import com.evanne.crudexercise1.user.exceptions.UserNotFoundException;
import com.evanne.crudexercise1.user.entities.User;
import com.evanne.crudexercise1.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> listAll(){
        return (List<User>) repository.findAll();
     }

     public  void save(User user){
        repository.save(user);
     }

     public User get(Integer id) throws UserNotFoundException{
       Optional<User> result = repository.findById(id);
       if (result.isPresent()){
           return result.get();
       }throw new UserNotFoundException("Could not find any users" + id);
     }

     public void delete(Integer id) throws UserNotFoundException {
        Long count = repository.countById(id);
        if(count == null || count == 0 ){
            throw new UserNotFoundException("Could not find any users" + id);
        }
        repository.deleteById(id);
     }
}
