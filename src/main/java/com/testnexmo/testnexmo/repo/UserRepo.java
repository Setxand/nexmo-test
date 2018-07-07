package com.testnexmo.testnexmo.repo;

import com.testnexmo.testnexmo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByPhoneNumber(String phoneNumber);
}
