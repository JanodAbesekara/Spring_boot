package com.example.portpolio.repo;

import com.example.portpolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo  extends JpaRepository<User, Integer> {
}
