package com.GenesisResources.Registration.system.Controller;

import com.GenesisResources.Registration.system.Repository.UsersRepository;
import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UsersController {
    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/user")
    public  void createNewUser() {

    }

    @GetMapping("/user/{ID}")
    public void getUser() {

    }

    @GetMapping("/users")
    public void getUsers() {

    }

    @PutMapping("/user")
    public void updateUser() {

    }

    @DeleteMapping("/user/{ID}")
        public void deleteUser() {

    }








}
