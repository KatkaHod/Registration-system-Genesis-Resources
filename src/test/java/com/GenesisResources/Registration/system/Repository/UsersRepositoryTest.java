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
import java.util.Arrays;
import java.util.List;


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

        when(jdbcTemplate.queryForObject(eq(Sql.getSelectUserByIdSql()), any(RowMapper.class), eq(ID))).thenReturn(expectedUser);

        UserModel actualUser = usersRepository.getUserById(ID);

        assertEquals(expectedUser.getID(), actualUser.getID());
        assertEquals(expectedUser.getName(), actualUser.getName());
        assertEquals(expectedUser.getSurname(), actualUser.getSurname());

        verify(jdbcTemplate).queryForObject(eq(Sql.getSelectUserByIdSql()), any(RowMapper.class), eq(ID));
    }


    @Test
    public void getAllUsersTest() {
        UserModel firstUser = new UserModel();
        firstUser.setID(2L);
        firstUser.setName("Katerina");
        firstUser.setSurname("Hodslavska");

        UserModel secondUser = new UserModel();
        secondUser.setID(3L);
        secondUser.setName("Anna");
        secondUser.setSurname("Novakova");

        List<UserModel> expectedUsers = Arrays.asList(firstUser, secondUser);

        when(jdbcTemplate.query(eq(Sql.getSelectAllUsersSql()), any(RowMapper.class))).thenReturn(expectedUsers);

        List<UserModel> actualUsers = usersRepository.getAllUsers();

        assertEquals(expectedUsers.size(), actualUsers.size());

        for (int i = 0; i < expectedUsers.size(); i++) {
            assertEquals(expectedUsers.get(i).getID(), actualUsers.get(i).getID());
            assertEquals(expectedUsers.get(i).getName(), actualUsers.get(i).getName());
            assertEquals(expectedUsers.get(i).getSurname(), actualUsers.get(i).getSurname());
        }
        verify(jdbcTemplate).query(eq(Sql.getSelectAllUsersSql()), any(RowMapper.class));
    }


    @Test
    public void updateUserTest() {
        Long ID = 1L;
        String updatedName = "Marie";
        String updatedSurname = "Novakova";

        usersRepository.updateUser(ID, updatedName, updatedSurname);

        verify(jdbcTemplate).update(eq(Sql.getUpdateUserSql()), eq(updatedName), eq(updatedSurname), eq(ID));

    }

    @Test
    public void deleteUserTest() {
        Long ID = 1L;
        usersRepository.deleteUser(ID);
        verify(jdbcTemplate).update(eq(Sql.getDeleteUserSql()), eq(ID));

    }


}
