package com.idol.model.mapper;

import com.idol.model.User;
import com.idol.payload.UserDto;

public class ModelMapper {
    public static User mapUserFromUserDto (UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setContactNumber(userDto.getContactNumber());
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        return user;
    }
}
