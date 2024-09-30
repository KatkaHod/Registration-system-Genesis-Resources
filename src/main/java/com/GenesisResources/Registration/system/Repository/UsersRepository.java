package com.GenesisResources.Registration.system.Repository;

import com.GenesisResources.Registration.system.Model.UserModel;
import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.GenesisResources.Registration.system.Settings.Sql;
import java.util.List;

@Repository
public class UsersRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UuidGenerator uuidGenerator;

    //no need to generate a new ID because it is auto-increment in database
    public void createUser(UserModel user) {
        String uuid = uuidGenerator.generateUuid();
        user.setUuid(uuid);

        System.out.println("Inserting User: Name=" + user.getName() + ", Surname=" + user.getSurname() + ", PersonID=" + user.getPersonID() + ", Uuid=" + user.getUuid());

        jdbcTemplate.update(Sql.getInsertUserSql(), user.getName(), user.getSurname(), user.getPersonID(), user.getUuid());
    }

    //gets a user from the database by id using jdbcTemplate, converts the result into a UserModel and returns the user with the ID, Name and Surname set.
    public UserModel getUserById(Long id) {
        return jdbcTemplate.queryForObject(Sql.getSelectUserByIdSql(), (rs, rowNum) -> {
            UserModel user = new UserModel();
            user.setID(rs.getLong("ID"));
            user.setName(rs.getString("Name"));
            user.setSurname(rs.getString("Surname"));
            return user;
        }, id);
    }

    public List<UserModel> getAllUsers() {
        return jdbcTemplate.query(Sql.getSelectAllUsersSql(), (rs, rowNum) -> {
            UserModel user = new UserModel();
            user.setID(rs.getLong("ID"));
            user.setName(rs.getString("Name"));
            user.setSurname(rs.getString("Surname"));
            return user;
        });
    }

    public void updateUser(Long ID, String Name, String Surname) {
        jdbcTemplate.update(Sql.getUpdateUserSql(), Name, Surname, ID);
    }

    public void deleteUser(Long ID) {
        jdbcTemplate.update(Sql.getDeleteUserSql(), ID);
    }


}
