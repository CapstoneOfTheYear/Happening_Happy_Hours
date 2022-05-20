package com.capstone.happening_happy_hours.repositories;

import com.capstone.happening_happy_hours.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(long id);
//    User findUserByName(String name);
    User findUserByEmail(String email);
    User findByEmail(String email);
    User findUserByPhone(String phone);
    User findByUsername(String username);
    User getByOwnsBusiness(boolean ownsBusiness);
}
