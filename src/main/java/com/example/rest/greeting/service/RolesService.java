package com.example.rest.greeting.service;

import java.util.List;

import com.example.rest.greeting.entity.Roles;
import com.example.rest.greeting.repository.RolesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getAll() {
        return rolesRepository.findAll();
    }
}
