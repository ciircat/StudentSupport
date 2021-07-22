package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);

}
