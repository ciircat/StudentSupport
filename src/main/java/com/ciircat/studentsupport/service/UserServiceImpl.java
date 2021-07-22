package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.User;
import com.ciircat.studentsupport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserServiceInterface{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long aLong) {
        return null;
    }

    @Override
    public User save(User user) {
        this.userRepository.save(user);
        return user;
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public Boolean usernameIsUnique(String username) {

        User u = this.userRepository.findByUsername(username);
        if (u == null){
            return true;
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {

        User user = this.userRepository.findByUsername(username);
        return user;
    }
}
