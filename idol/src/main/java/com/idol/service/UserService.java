package com.idol.service;


import com.idol.payload.UserDto;

import java.util.List;

public interface UserService {

    //Create user operation
    UserDto createUser(UserDto userDto);

    //Get all user operation
    List<UserDto> getAllUsers();

    //Get userById operation
    UserDto getUserById(long id);

    //Update user operation
    UserDto updateUser(UserDto userDto, Long id);

    //Delete user operation
    void deleteUser(long id);

}
