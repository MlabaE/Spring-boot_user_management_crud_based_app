package com.evanne.crudexercise1;

import com.evanne.crudexercise1.user.entities.User;
import com.evanne.crudexercise1.user.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("evanne@gmail.com");
        user.setPassword("1234");
        user.setFirstName("Evanne");
        user.setLastName("Mlaba");

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = userRepository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
       Optional<User> optionalUser = userRepository.findById(1);
       User user = optionalUser.get();
       user.setPassword("hello");
       userRepository.save(user);

       User updatedUser = userRepository.findById(1).get();
       Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hello");
    }

    @Test
    public void testGet(){
        Optional<User> optionalUser = userRepository.findById(1);

        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }
}
