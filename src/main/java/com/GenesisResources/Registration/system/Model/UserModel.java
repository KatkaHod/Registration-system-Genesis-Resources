package com.GenesisResources.Registration.system.Model;


public class UserModel {
    private Long ID;
    private String Name;
    private String Surname;
    private String PersonID;
    private String Uuid;

    public UserModel() {
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getID() {
        return ID;
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        PersonID = personID;
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

    public String getPersonId() {
        return PersonID;
    }

    public void setPersonId(String personId) {
        PersonID = personId;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }
}
