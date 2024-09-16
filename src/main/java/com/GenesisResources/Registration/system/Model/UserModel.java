package com.GenesisResources.Registration.system.Model;
import com.GenesisResources.Registration.system.Service.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;


public class UserModel {

    //Using JDBC, you do not need to have an entity in the sense of a JPA. Just have a POJO (Plain Old Java Object).
    private Long ID;
    private String Name;
    private String Surname;
    private String PersonId;
    private UUID Uuid;

    public Long getId() {
        return ID;
    }

    public void setId(Long ID) {
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

    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String personId) {
        PersonId = personId;
    }

    public UUID getUuid() {
        return Uuid;
    }

    public void setUuid(UUID uuid) {
        Uuid = uuid;
    }
}
