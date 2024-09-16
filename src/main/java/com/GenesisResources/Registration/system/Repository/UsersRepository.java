package com.GenesisResources.Registration.system.Repository;

import com.GenesisResources.Registration.system.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createUser(UserModel user) {
        String sql = "INSERT INTO Users (Name, Surname, Person_ID, Uuid) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getSurname(), user.getPersonId(), user.getUuid());
    }

    public UserModel getUserById(Long id) {
        String sql = "SELECT ID, Name, Surname FROM users WHERE ID = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, rs -> {
            if (rs.next()) {
                UserModel user = new UserModel();

                user.setId(rs.getLong("ID"));
                user.setName(rs.getString("Name"));
                user.setSurname(rs.getString("Surname"));
                return user;
            }
            return null;
        });
    }


    public List<UserModel> getAllUsers() {
        String sql = "SELECT ID, Name, Surname FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserModel user = new UserModel();
            user.setId(rs.getLong("ID"));
            user.setName(rs.getString("Name"));
            user.setSurname(rs.getString("Surname"));
            return user;
        });
    }

    public void updateUser(Long id, String name, String surname) {
        String sql = "UPDATE users SET Name = ?, Surname = ? WHERE ID = ?";
        jdbcTemplate.update(sql, name, surname, id);
    }

    public void deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }


}
