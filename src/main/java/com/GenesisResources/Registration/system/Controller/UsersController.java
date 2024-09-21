package com.GenesisResources.Registration.system.Controller;

import com.GenesisResources.Registration.system.Model.UserModel;
import com.GenesisResources.Registration.system.Repository.UsersRepository;
import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
    public ResponseEntity<?> createNewUser(@RequestBody UserModel user) {
        System.out.println("Received UserModel: " + user);
        System.out.println("Name: " + user.getName());
        System.out.println("Surname: " + user.getSurname());
        System.out.println("PersonID: " + user.getPersonID());

        try {
            userRepository.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        try {
            UserModel user = userRepository.getUserById(id);

            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
    }


    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserModel> users = userRepository.getAllUsers();

            if (users.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No users found");
            }

            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
    }




    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody UserModel user) {
        try {
            if (user.getID() == null) {
                return ResponseEntity.badRequest().body("User ID must be provided for update");
            }

            userRepository.updateUser(user.getID(), user.getName(), user.getSurname());
            return ResponseEntity.ok("User updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
    }


    @DeleteMapping("/user/{ID}")
    public void deleteUser(@PathVariable("ID") Long ID) {
        userRepository.deleteUser(ID);
    }


}
