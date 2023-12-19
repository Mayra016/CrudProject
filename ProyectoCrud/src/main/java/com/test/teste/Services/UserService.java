package com.test.teste.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.teste.Entities.UserEntity;
import com.test.teste.Interfaces.UserServiceInterface;
import com.test.teste.Repositories.UserRepository;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository data;
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());


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
    	data.deleteById(id);
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
        	UserEntity oldUser = optionalUser.get();
        	oldUser.setName(user.getName());
        	oldUser.setPhoneNumber(user.getPhoneNumber());
        	oldUser.setId(user.getId());
            data.save(oldUser);
            LOGGER.info("Usuario actualizado: " + oldUser);
        } else {
        	LOGGER.info("No se ha encontrado el id");
        }
    }




}
