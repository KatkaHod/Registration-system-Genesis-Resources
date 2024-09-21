package com.GenesisResources.Registration.system.Model;


public class UserModel {
    private Long ID;
    private String Name;
    private String Surname;
    private String PersonID;
    private String Uuid;

    public UserModel() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        PersonID = personID;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", PersonID='" + PersonID + '\'' +
                ", Uuid='" + Uuid + '\'' +
                '}';
    }
}
