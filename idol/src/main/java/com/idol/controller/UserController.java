package com.idol.controller;


import com.idol.payload.UserDto;
import com.idol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Get all user rest api
    @GetMapping
    public List<UserDto> getAllUsers() { return userService.getAllUsers(); }

    // Create user rest api
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    //Get user by Id rest api
    @GetMapping("/{id}")
    public ResponseEntity<UserDto>getUserById(@PathVariable (name = "id") Long id){
        return  ResponseEntity.ok(userService.getUserById(id));
    }

    //Update user rest api
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable(name = "id") Long id){
     UserDto userResponse = userService.updateUser(userDto,id);
     return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
    //Delete user rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id){
      userService.deleteUser(id);
      return new ResponseEntity<>("User entity deleted successfully.",HttpStatus.OK);
    }
}