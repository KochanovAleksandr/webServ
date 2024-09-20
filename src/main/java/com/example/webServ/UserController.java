package com.example.webServ;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
import java.util.Map;
import java.util.Random;

//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController

public class UserController {
	
	Random random = new Random();
	
	
	@GetMapping(path="/home", produces = "application/json")
	public ResponseEntity<Users> user()throws InterruptedException{
		Users user = new Users();
		Thread.sleep(1000+random.nextInt(1000));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping(path="/", consumes = "application/json", produces = "application/json" )
	public ResponseEntity<Users> usr(@Valid @RequestBody Users user) throws InterruptedException {
		String login = user.getLogin();
		String password = user.getPassword();
		Users usr = new Users(login, password);
		Thread.sleep(1000+random.nextInt(1000));
		return ResponseEntity.ok(usr);
	}
	
	@PostMapping(path="/users",produces = "application/json" )
	 public String addUser(@RequestBody  Map<String, String> users)throws InterruptedException {
        
		Users usr = new Users();
		
		usr.setLogin(users.get("login"));
		usr.setPassword(users.get("password"));
		Thread.sleep(1000+random.nextInt(1000));
		return usr.toString();
    }



}
