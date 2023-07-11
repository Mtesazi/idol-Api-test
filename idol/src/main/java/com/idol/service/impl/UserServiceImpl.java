package com.idol.service.impl;


import com.idol.exception.ResourceNotFoundException;
import com.idol.model.User;
import com.idol.payload.UserDto;
import com.idol.repository.UserRepository;
import com.idol.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {


    private  UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {

     User user = mapToEntity(userDto);
     User newUser = userRepository.save(user);
     UserDto userResponse = mapToDto(newUser);
     return userResponse;
    }

    @Override
    public UserDto getUserById(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        return mapToDto(user);
    }
    @Override
    public List<UserDto> getAllUsers(){

        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
      User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
      user.setFirstName(userDto.getFirstName());
      user.setLastName(userDto.getLastName());
      user.setContactNumber(user.getContactNumber());
      User updatedUser = userRepository.save(user);
      return mapToDto(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
        userRepository.delete(user);
    }


    //Convert Entity into DTO
    private UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setContactNumber(user.getContactNumber());
        return userDto;
    }

    //Converted DTO into Entity
    private User mapToEntity (UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setId(userDto.getId());
        user.setLastName(userDto.getLastName());
        user.setContactNumber(userDto.getContactNumber());
        return user;
    }
}
