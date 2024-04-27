package com.example.day4post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day4post.model.Data;
import com.example.day4post.repository.RepositoryData;
@Service
public class Service_2
{
    @Autowired
    public RepositoryData ab;
    // private PasswordEncoun pe;

    //create new user

    public Data createnewuser(@NonNull Data user)
    {
        return ab.save(user);
    }

    //getuser

    public List<Data> getAllusers()
    {
        return ab.findAll();
    }

    //EIETHER WAYS WE CAN FINDALL THE USERS BY FINDALL AS WELL AS THROUGH THE EMAIL
    
    //getuserusingemailid
    
    public Optional<Data> getModelByEmail(String email)
    {
        return ab.findByEmail(email);
    }

    //updateUser

    public Data updateUser(@NonNull String email,@RequestBody Data user)
    {
        return ab.findByEmail(email)
        .map(existingUser -> {
        existingUser.setOrigin(user.getOrigin());
        existingUser.setEmail(user.getEmail());
        existingUser.setDestination(user.getDestination());
        existingUser.setPrice(user.getPrice());
        return ab.save(existingUser);

        }
        )

        .orElseThrow(() -> new RuntimeException("User not found with this email: "+ email));

    }
    public void removeUser(@NonNull Integer userId)
    {
        ab.deleteById(userId);
    }

    
}