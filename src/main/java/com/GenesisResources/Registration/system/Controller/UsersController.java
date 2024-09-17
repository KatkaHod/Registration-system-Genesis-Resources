package com.GenesisResources.Registration.system.Controller;

import com.GenesisResources.Registration.system.Model.UserModel;
import com.GenesisResources.Registration.system.Repository.UsersRepository;
import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UsersController {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private UuidGenerator uuidGenerator;

    @Autowired
    JdbcTemplate jdbcTemplate;

        @PostMapping("/user")
        public ResponseEntity<String> createNewUser(@RequestBody UserModel user) {
            try {
                userRepository.createUser(user);

                return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
            }
        }


    @GetMapping("/user/{ID}")
    public UserModel getUser(@PathVariable("id") Long id) {
        return userRepository.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserModel> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserModel user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID must be provided for update");
        }

        userRepository.updateUser(user.getId(), user.getName(), user.getSurname());
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteUser(id);
    }


}
