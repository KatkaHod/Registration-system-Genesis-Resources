package com.GenesisResources.Registration.system.Settings;

public class Sql {

    private static final String INSERT_USER_SQL = "INSERT INTO users (Name, Surname, PersonID, Uuid) VALUES (?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID_SQL = "SELECT ID, Name, Surname FROM users WHERE ID = ?";
    private static final String SELECT_ALL_USERS_SQL = "SELECT ID, Name, Surname FROM users";
    private static final String UPDATE_USER_SQL = "UPDATE users SET Name = ?, Surname = ? WHERE ID = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE ID = ?";

    public static String getInsertUserSql() {
        return INSERT_USER_SQL;
    }

    public static String getSelectUserByIdSql() {
        return SELECT_USER_BY_ID_SQL;
    }

    public static String getSelectAllUsersSql() {
        return SELECT_ALL_USERS_SQL;
    }

    public static String getUpdateUserSql() {
        return UPDATE_USER_SQL;
    }

    public static String getDeleteUserSql() {
        return DELETE_USER_SQL;
    }



}
