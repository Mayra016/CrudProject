package com.test.teste.Interfaces;

import java.util.List;
import java.util.Optional;

import com.test.teste.Entities.UserEntity;

public interface UserServiceInterface {
    public List<UserEntity>list();
    public Optional<UserEntity>listId(long id);
    public int saveUser(UserEntity user);
    public void delete(long id);
    public void update(UserEntity user);
}
