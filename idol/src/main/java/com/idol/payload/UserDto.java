package com.idol.payload;


import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String contactNumber;
}
