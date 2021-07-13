package com.example.rest.greeting.controller;

import java.util.List;

import com.example.rest.greeting.entity.UserRole;
import com.example.rest.greeting.entity.UserRoleView;
import com.example.rest.greeting.entity.Users;
import com.example.rest.greeting.service.UsersService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    
    @GetMapping("/gets")
    public List<Users> getUsers() {
    	return usersService.getAll();
    }
    
    @GetMapping("/get/{name}")
    public Users getUser(@PathVariable final String name) {
    	return usersService.getUserByName(name);
    }
    
    @GetMapping("/get_username/{userName}")
    public Users getUserByUserName(@PathVariable final String userName) {
    	return usersService.getUserByUserName(userName);
    }

    @GetMapping("/get_email/{email}")
    public Users getUserByEmail(@PathVariable final String email) {
    	return usersService.getUserByEmail(email);
    }

    @GetMapping("/getRole/")
    public List<UserRoleView> getAllUserRole(){
        return usersService.getAllUserRole();
    }

    @GetMapping("/getrole_by_userid/{userId}")
    public UserRoleView getUserRoleByUserId(@PathVariable final Long userId){
        return usersService.getUserRoleByUserId(userId);
    }

    @GetMapping("/getrole_by_email/{email}")
    public UserRoleView getUserRoleByEmail(@PathVariable final String email){
        return usersService.getUserRoleByEmail(email);
    }

    @GetMapping("/get_posts")
    public List<Object[]> getUserPosts() {
    	return usersService.getUserPosts();
    }

    @GetMapping("/get_posts/{userid}")
    public List<Object[]> getUserPosts(@PathVariable final int userid) {
    	return usersService.getUserPosts(userid);
    }

    @PostMapping("/create")
    public void create(@RequestBody final Users users){
    	usersService.createUser(users);
    }

    @PutMapping("/edit/{userId}")
    public void edit(@RequestBody final Users users, @PathVariable final Long userId){
    	usersService.editUser(users, userId);
    }

    @DeleteMapping("/delete/{userid}")
    public void delete(@PathVariable final Long userid) {
        usersService.deleteUser(userid);
    }

    @PostMapping("/create_role")
    public void create(@RequestBody final UserRole userRole){
        usersService.createUserRole(userRole);
    }

    @PutMapping("/edit_role/{roleId}")
    public void ediRole(@RequestBody final UserRole userRole, @PathVariable final Long roleId){
    	usersService.editRole(userRole, roleId);
    }
    
    @DeleteMapping("/delete_role/{userRoleId}")
    public void deleteUserRole(@PathVariable final Long userRoleId){
    	usersService.deleteUserRole(userRoleId);
    }
}
