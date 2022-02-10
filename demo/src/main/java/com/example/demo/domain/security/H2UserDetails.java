package com.example.demo.domain.security;

import com.example.demo.domain.entity.RoleEntity;
import com.example.demo.domain.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class H2UserDetails implements UserDetails {
    private UserEntity userEntity;
    private Date loggedInTime;

    public H2UserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
        loggedInTime = new Date();
    }

    public Date getLoggedInTime() {
        return loggedInTime;
    }

    public List<String > getRoleAuthorities(){
        List<RoleEntity> entities = userEntity.getRoleEntities();
        List<String> authorities = new ArrayList<>();

        for (RoleEntity entity:entities){
            authorities.add(entity.getName());
        }
        return authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<RoleEntity> entities = userEntity.getRoleEntities();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (RoleEntity entity:entities){
            authorities.add(new SimpleGrantedAuthority(entity.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
