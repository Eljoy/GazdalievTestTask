package com.sprhib.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Named;
import java.security.MessageDigest;

/**
 * Created by Home on 16.01.2015.
 */
@Named
public class PasswordHelper implements PasswordEncoder{
    private MessageDigest md;
    public PasswordHelper(){
        try {
            md = MessageDigest.getInstance("MD5");
        }

    catch (Exception e ){
        e.printStackTrace();
    }
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return true;
    }
}
