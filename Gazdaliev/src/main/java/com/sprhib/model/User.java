package com.sprhib.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Home on 14.01.2015.
 */
@Entity
@Table(name = "users")
public class User extends Model implements UserDetails {

    private String username;

    private String password;

    public  User(){}
    public User(int id) {
        super(id);
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> userRoles = new HashSet<>();



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> result = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            result.add(new SimpleGrantedAuthority(userRole.getListRole().name()));
        }

        return result;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
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

    public void setPassword(String password) {
        this.password = password;
    }



    public void setUsername(String username) {
        this.username = username;
    }
}
