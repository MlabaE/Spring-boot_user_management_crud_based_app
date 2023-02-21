package com.evanne.crudexercise1.user.repositories;

import com.evanne.crudexercise1.user.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}
