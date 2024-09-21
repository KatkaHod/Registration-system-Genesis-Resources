package com.GenesisResources.Registration.system.Repository;

import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsersRepositoryTest {

    /* Required 'Mockito' dependency (has been added)
    * Test the UsersRepository class that provides the internal logic with the database. */

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private UuidGenerator uuidGenerator;

    @InjectMocks
    private UsersRepository usersRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {

    }

   @Test
    public void getUserByIdTest() {

    }

    @Test
    public void getAllUsersTest() {

    }

    @Test
    public void updateUserTest() {

    }

    @Test
    public void deleteUserTest() {

    }




}
