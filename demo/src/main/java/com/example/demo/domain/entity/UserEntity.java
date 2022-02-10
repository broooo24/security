package com.example.demo.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> roleEntities;

    public List<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(List<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
