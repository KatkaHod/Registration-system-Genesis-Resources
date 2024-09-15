package com.GenesisResources.Registration.system.Controller;

import com.GenesisResources.Registration.system.Repository.UsersRepository;
import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;






}
