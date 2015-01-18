package com.sprhib.dao;

import com.sprhib.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by Home on 14.01.2015.
 */
@Repository
public class UserDAOImpl implements UserDAO, UserDetailsService {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public User getUser(int id) {
        User user = (User) getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return getCurrentSession().createQuery("from User").list();
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username");
        query.setParameter("username", username);
        User result = (User) query.uniqueResult();
        return result;
    }
}
