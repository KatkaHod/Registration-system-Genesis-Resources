package com.GenesisResources.Registration.system.Repository;

import com.GenesisResources.Registration.system.Model.UserModel;
import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UuidGenerator uuidGenerator;


    //added constants for better code maintenance
    private static final String INSERT_USER_SQL = "INSERT INTO users (Name, Surname, PersonID, Uuid) VALUES (?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID_SQL = "SELECT ID, Name, Surname FROM users WHERE ID = ?";
    private static final String SELECT_ALL_USERS_SQL = "SELECT ID, Name, Surname FROM users";
    private static final String UPDATE_USER_SQL = "UPDATE users SET Name = ?, Surname = ? WHERE ID = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE ID = ?";


    //There is no need to generate a new ID because it is auto-increment in database
    public void createUser(UserModel user) {
        String uuid = uuidGenerator.generateUuid();
        user.setUuid(uuid);

        System.out.println("Inserting User: Name=" + user.getName() + ", Surname=" + user.getSurname() + ", PersonID=" + user.getPersonID() + ", Uuid=" + user.getUuid());

        jdbcTemplate.update(INSERT_USER_SQL, user.getName(), user.getSurname(), user.getPersonID(), user.getUuid());
    }

    public UserModel getUserById(Long id) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_ID_SQL, (rs, rowNum) -> {
            UserModel user = new UserModel();
            user.setID(rs.getLong("ID"));
            user.setName(rs.getString("Name"));
            user.setSurname(rs.getString("Surname"));
            return user;
        }, id);
    }

    public List<UserModel> getAllUsers() {
        return jdbcTemplate.query(SELECT_ALL_USERS_SQL, (rs, rowNum) -> {
            UserModel user = new UserModel();
            user.setID(rs.getLong("ID"));
            user.setName(rs.getString("Name"));
            user.setSurname(rs.getString("Surname"));
            return user;
        });
    }

    public void updateUser(Long ID, String Name, String Surname) {
        jdbcTemplate.update(UPDATE_USER_SQL, Name, Surname, ID);
    }

    public void deleteUser(Long ID) {
        jdbcTemplate.update(DELETE_USER_SQL, ID);
    }


}
