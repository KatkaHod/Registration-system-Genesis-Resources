package com.GenesisResources.Registration.system.Repository;

import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UuidGenerator uuidGenerator;










}
