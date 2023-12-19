package com.test.teste.Controllers;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.teste.Entities.UserEntity;
import com.test.teste.Interfaces.UserServiceInterface;

@Controller
@RequestMapping
public class UserController {
    @Autowired
	private UserServiceInterface service;
	
    @GetMapping("/list")
	public String list(Model model) {
		List<UserEntity>users=service.list();
		model.addAttribute("users", users);
    	return "index";
    }
    
    @GetMapping("/new")
    public String newUser(Model model) {
    	model.addAttribute("user", new UserEntity());
    	return "form";
    }
    
    @PostMapping("/save")
    public String saveUserData(@Valid UserEntity user, Model model) {
    	Long userId = user.getId();
    	if (userId!=null && userId>=1) {
    		service.update(user);  		
    	} else {
    		service.saveUser(user);
    	}
    	return "redirect:/list";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
    	Optional<UserEntity>user=service.listId(id);
    	model.addAttribute("user", user);
    	return "form";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model) {
    	service.delete(id);
    	return"redirect:/list";
    }
    
    
}
