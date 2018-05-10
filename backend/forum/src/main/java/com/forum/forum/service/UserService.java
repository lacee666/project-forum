package com.forum.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.forum.model.*;
import com.forum.forum.repository.*;
import com.forum.forum.service.exception.*;

import java.sql.Timestamp;

import static com.forum.forum.model.User.Role.USER;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private User user;

    public User login(User user) throws UserNotValidException {
        if(user == null){
            System.out.println("User is null.");
            return null;
        }
        try{
            if (isValid(user)) {
                this.user = userRepository.findByUsername(user.getUsername());
                System.out.println("User found: " + this.user.toString());
                return this.user;
            }else{
                System.out.println("Username or password not valid for: " + user.getUsername());
                return null;
            }
        }catch(Exception e){
            throw new UserNotValidException();
        }
    }
    public boolean isValid(User user) {
        return userRepository.findByUsername(user.getUsername()) != null && user.getPassword().equals(userRepository.findByUsername(user.getUsername()).getPassword());
    }
    public User register(User user) throws UserNotValidException {
        try{
            if (user.getPassword().length() > 16 || user.getPassword().length() < 6 || user.getUsername().length() < 6 || user.getUsername().length() > 16) {
                throw new UserNotValidException();
            }
            user.setRole(USER);
            user.setRegistrationDate(new Timestamp(System.currentTimeMillis()).toString());
            /*
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            */
            userRepository.save(user);
            System.out.println("User has been saved: " + user.toString());
            return user;
        }catch (Exception e){
            throw new UserNotValidException();
        }

    }
    public User getUserById(long id) throws UserNotValidException {
        try{
            return userRepository.findById(id);
        }catch(Exception e) {
            throw new UserNotValidException();
        }
    }
    public User getUserByUserName(String userName) throws UserNotValidException {
        try{
            return userRepository.findByUsername(userName);
        }catch(Exception e) {
            throw new UserNotValidException();
        }
    }


    public boolean isLoggedIn() {
        return true;
    }

    public User getUser() throws  UserNotValidException {
        return this.user;
    }
}