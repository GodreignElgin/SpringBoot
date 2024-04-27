package com.example.day4post.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day4post.model.Data;

public interface RepositoryData extends JpaRepository<Data,Integer>
{
    Optional<Data> findByEmail(String username);
}

