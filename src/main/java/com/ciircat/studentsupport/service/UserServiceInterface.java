package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.User;

public interface UserServiceInterface extends CrudServiceInterface<User, Long>{
    Boolean usernameIsUnique(String username);

    User findByUsername(String username);
}
