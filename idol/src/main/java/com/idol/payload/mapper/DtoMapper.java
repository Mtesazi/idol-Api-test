package com.idol.payload.mapper;

import com.idol.model.User;
import com.idol.payload.UserDto;

public class DtoMapper {
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setContactNumber(user.getContactNumber());
        userDto.setLastName(user.getLastName());
        userDto.setFirstName(user.getFirstName());
        return userDto;
    }
}
