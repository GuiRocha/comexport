package com.guilherme.comexporttest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "contacts")

    private List<User> users = new ArrayList<>();

    public Contact() {
    }

    public Contact(Long id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
