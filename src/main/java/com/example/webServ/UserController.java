package com.example.webServ;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

//import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
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

		Thread.sleep(1000+random.nextInt(1000));
		return ResponseEntity.ok(user);
	}
	

	@PostMapping(path="/users")
	public ResponseEntity<?> users(@RequestBody Map<String,String> requestBody) throws InterruptedException {

		Thread.sleep(1000+random.nextInt(1000));
		if (requestBody.get("login")==null||requestBody.get("password")==null||requestBody.size()!=2) {
			HashMap<String, Object> errorResponseBody = new HashMap<>();

			//String message = "Not Valid Date";
			errorResponseBody.put("status code",400);
			errorResponseBody.put("message","Not Valid Date");
            return new ResponseEntity<>(errorResponseBody,HttpStatus.BAD_REQUEST);
        }
			Users responseBody = new Users(requestBody.get("login"), requestBody.get("password"));
			return new ResponseEntity<>(responseBody,HttpStatus.OK) ;

	}
}





