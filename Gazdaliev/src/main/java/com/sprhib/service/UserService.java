package com.sprhib.service;

import com.sprhib.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by Home on 14.01.2015.
 */
public interface UserService {
    public void addUser(User user);
    public User getUser(int id);
    public List<User> getUsers();
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;
}
