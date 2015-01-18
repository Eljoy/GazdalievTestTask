package com.sprhib.controller;

import com.sprhib.model.User;
import com.sprhib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Home on 14.01.2015.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public ModelAndView addUserPage(){
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ModelAndView addingUser(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("index");
        userService.addUser(user);

        String message = "User was succesfully added";
        modelAndView.addObject("message", message);
        return modelAndView;
    }
    @RequestMapping(value = "/users")
    public ModelAndView showUsersList(){
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }


}
