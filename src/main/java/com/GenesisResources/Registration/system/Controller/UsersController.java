package com.GenesisResources.Registration.system.Controller;

import com.GenesisResources.Registration.system.Model.UserModel;
import com.GenesisResources.Registration.system.Repository.UsersRepository;
import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class UsersController {
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private UuidGenerator uuidGenerator;



    @PostMapping("/user")
    public void createNewUser(@RequestBody UserModel user) {
        String uuid = uuidGenerator.generateUuid();
        user.setUuid(UUID.fromString(uuid));

        userRepository.createUser(user);

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
