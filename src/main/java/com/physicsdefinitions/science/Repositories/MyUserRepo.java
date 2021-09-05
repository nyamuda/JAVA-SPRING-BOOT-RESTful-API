package com.physicsdefinitions.science.Repositories;

import com.physicsdefinitions.science.Models.MyUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Integer> {
    public MyUser findByUsername(String username);
}
