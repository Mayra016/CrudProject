package com.test.teste.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.teste.Entities.UserEntity;



@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
}
