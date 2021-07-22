package com.ciircat.studentsupport.converters;

import com.ciircat.studentsupport.commands.UserCommand;
import com.ciircat.studentsupport.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<UserCommand, User> {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserConverter(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User convert(UserCommand userCommand) {
        User toReturn = new User();
        toReturn.setEmail(userCommand.getEmail());
        toReturn.setUsername(userCommand.getUsername());
        toReturn.setPassword(passwordEncoder.encode(userCommand.getPassword()));
        toReturn.setActive(true);
        toReturn.setUniversityIdentificationCode(userCommand.getUniversityIdentificationCode());
        return toReturn;
    }
}
