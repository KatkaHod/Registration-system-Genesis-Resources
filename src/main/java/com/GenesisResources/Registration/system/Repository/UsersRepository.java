package com.GenesisResources.Registration.system.Repository;

import com.GenesisResources.Registration.system.Model.UserModel;
import com.GenesisResources.Registration.system.Service.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    IDGenerator idGenerator;


    //added constants for better code maintenance
    private static final String INSERT_USER_SQL = "INSERT INTO users (ID, Name, Surname, PersonID, Uuid) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID_SQL = "SELECT ID, Name, Surname FROM users WHERE ID = ?";
    private static final String SELECT_ALL_USERS_SQL = "SELECT ID, Name, Surname FROM users";
    private static final String UPDATE_USER_SQL = "UPDATE users SET Name = ?, Surname = ? WHERE ID = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE ID = ?";


    public void createUser(UserModel user) {
        jdbcTemplate.update(INSERT_USER_SQL, user.getId(), user.getName(), user.getSurname(), user.getPersonId(), user.getUuid());
    }

    public UserModel getUserById(Long id) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_ID_SQL, (rs, rowNum) -> {
            UserModel user = new UserModel();
            user.setId(rs.getLong("ID"));
            user.setName(rs.getString("Name"));
            user.setSurname(rs.getString("Surname"));
            return user;
        }, id);
    }

    public List<UserModel> getAllUsers() {
        return jdbcTemplate.query(SELECT_ALL_USERS_SQL, (rs, rowNum) -> {
            UserModel user = new UserModel();
            user.setId(rs.getLong("ID"));
            user.setName(rs.getString("Name"));
            user.setSurname(rs.getString("Surname"));
            return user;
        });
    }

    public void updateUser(Long id, String name, String surname) {
        jdbcTemplate.update(UPDATE_USER_SQL, name, surname, id);
    }

    public void deleteUser(Long id) {
        jdbcTemplate.update(DELETE_USER_SQL, id);
    }


}
