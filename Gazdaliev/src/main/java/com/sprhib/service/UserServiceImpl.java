package com.sprhib.service;

import com.sprhib.dao.UserDAO;
import com.sprhib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Home on 14.01.2015.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }


    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userDAO.loadUserByUsername(login);
    }


}
