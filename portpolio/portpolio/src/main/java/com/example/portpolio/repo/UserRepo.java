package com.example.portpolio.repo;

import com.example.portpolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo  extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where id= ?1", nativeQuery = true)
    User getuserByid(Integer userId);
}
