package com.test.teste.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.teste.Entities.UserEntity;
import com.test.teste.Interfaces.UserServiceInterface;
import com.test.teste.Repositories.UserRepository;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository data;


    @Override
    public List<UserEntity>list() {
        return (List<UserEntity>)data.findAll();
    }
    
    @Override
    public Optional<UserEntity>listId(long id) {
		return data.findById(id);
	}
    
    @Override
    public void delete(long id) {
	}
    
    @Override
    public int saveUser(UserEntity user) {
        int response = 0;
        UserEntity userData = data.save(user);
        if (!userData.equals(null)) {
        	response = 1;
        }
        return response;
    }
    
    @Override
    public void update(UserEntity user) {
        Optional<UserEntity> optionalUser = data.findById(user.getId());
        if (optionalUser.isPresent()) {
            UserEntity toUpdateUser = optionalUser.get();
            toUpdateUser.setName(user.getName());
            toUpdateUser.setPhoneNumber(user.getPhoneNumber());
            data.save(toUpdateUser);
        }
    }




}
