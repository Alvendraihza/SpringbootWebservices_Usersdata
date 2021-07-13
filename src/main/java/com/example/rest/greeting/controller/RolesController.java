package com.example.rest.greeting.controller;

import java.util.List;

import com.example.rest.greeting.entity.Roles;
import com.example.rest.greeting.service.RolesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RolesController {
    private RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }
        
    @GetMapping("/gets")
    public List<Roles> getUserRoles() {
    	// return usersService.getAll();
        return rolesService.getAll();
    }

}
