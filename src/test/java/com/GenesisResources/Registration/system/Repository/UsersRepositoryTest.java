package com.GenesisResources.Registration.system.Repository;
import com.GenesisResources.Registration.system.Model.UserModel;
import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.eq;
import com.GenesisResources.Registration.system.Settings.Sql;


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
        UserModel userModel = new UserModel();

        userModel.setID(ID);
        userModel.setName("Katerina");
        userModel.setSurname("Hodslavska");


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
