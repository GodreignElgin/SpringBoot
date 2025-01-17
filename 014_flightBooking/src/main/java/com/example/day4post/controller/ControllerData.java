package com.example.day4post.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4post.model.Data;
import com.example.day4post.service.Service_2;

// import com.example.day4post.service.Service;
import lombok.NonNull;

@RestController
@RequestMapping("/api/data")
public class ControllerData 
{
    

@Autowired
private  Service_2 userService;

@PostMapping("/createUser")

public ResponseEntity<Data> createUser(@NonNull @RequestBody Data user) {

Data createdUser = userService.createnewuser(user);

return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

}

@GetMapping("readUser/{email}")

//@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")

public ResponseEntity<?> getUserByEmail(@PathVariable String email) 
{

Optional<Data> user = userService.getModelByEmail(email);

return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))

.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

}

@GetMapping("/readUsers")

// @PreAuthorize("hasAuthority('ADMIN')")

public ResponseEntity<List<Data>> getAllUsers() 
{

List<Data> users = userService.getAllusers();

return new ResponseEntity<>(users, HttpStatus.OK);

}

@PutMapping("updateUser/{email}")

// @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")

public ResponseEntity<Data> updateUser(@NonNull @PathVariable String email,@RequestBody Data updateRequest) 
{

Data updated = userService.updateUser(email, updateRequest);

return new ResponseEntity<>(updated, HttpStatus.OK);

}

@DeleteMapping("deleteUser/{userId}")

// @PreAuthorize("hasAuthority('ADMIN')")

public ResponseEntity<Void> removeUser(@NonNull @PathVariable Integer userId) {

userService.removeUser(userId);

return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}

}