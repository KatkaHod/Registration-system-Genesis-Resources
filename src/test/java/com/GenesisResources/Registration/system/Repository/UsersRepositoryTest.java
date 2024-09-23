package com.GenesisResources.Registration.system.Repository;
import com.GenesisResources.Registration.system.Model.UserModel;
import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.eq;
import com.GenesisResources.Registration.system.Settings.Sql;
import org.springframework.jdbc.core.RowMapper;


public class UsersRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private UuidGenerator uuidGenerator;

    @InjectMocks
    private UsersRepository usersRepository;
    private UserModel userModel;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testCreateUser() {
        UserModel userModel = new UserModel();

        userModel.setName("Katerina");
        userModel.setSurname("Hodslavska");
        userModel.setPersonID("iM5sO6zXcW7v");

        String generatedUuid = "123e4567-e89b-12d3-a456-426614174000";
        when(uuidGenerator.generateUuid()).thenReturn(generatedUuid);

        usersRepository.createUser(userModel);

        verify(jdbcTemplate).update(eq(Sql.getInsertUserSql()),
                eq("Katerina"),
                eq("Hodslavska"),
                eq("iM5sO6zXcW7v"),
                eq(generatedUuid)
        );

    }


    @Test
    public void getUserByIdTest() {
        Long ID = 1L;
        UserModel expectedUser = new UserModel();

        expectedUser.setID(ID);
        expectedUser.setName("Katerina");
        expectedUser.setSurname("Hodslavska");

        when(jdbcTemplate.queryForObject(eq(Sql.getSelectUserByIdSql()), any(RowMapper.class), eq(ID)))
                .thenReturn(expectedUser);

        UserModel actualUser = usersRepository.getUserById(ID);

        assertEquals(expectedUser.getID(), actualUser.getID());
        assertEquals(expectedUser.getName(), actualUser.getName());
        assertEquals(expectedUser.getSurname(), actualUser.getSurname());

        verify(jdbcTemplate).queryForObject(eq(Sql.getSelectUserByIdSql()), any(RowMapper.class), eq(ID));
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
