package com.GenesisResources.Registration.system.Repository;

import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

@Repository
public class UsersRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UuidGenerator uuidGenerator;
    @Autowired
    private DataSourceProperties dataSourceProperties;

    private static final String SELECT_ALL_USERS = "SELECT * FROM users";















}
