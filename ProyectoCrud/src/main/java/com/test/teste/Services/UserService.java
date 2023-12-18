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
		return null;
	}
    
    @Override
    public void delete(long id) {
	}
    
	@Override
	public int save(UserEntity user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
