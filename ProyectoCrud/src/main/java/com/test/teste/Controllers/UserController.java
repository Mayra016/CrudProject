package com.test.teste.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.teste.Entities.UserEntity;
import com.test.teste.Interfaces.UserServiceInterface;

@Controller
@RequestMapping
public class UserController {
    @Autowired
	private UserServiceInterface service;
	
    @GetMapping("list")
	public String list(Model model) {
		List<UserEntity>users=service.list();
		model.addAttribute("users", users);
    	return "index";
    }
}
