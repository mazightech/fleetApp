package com.maztech.fleet.repos;

import com.maztech.fleet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    User findByFirstnameAndLastname(String firstname, String lastname);

}
