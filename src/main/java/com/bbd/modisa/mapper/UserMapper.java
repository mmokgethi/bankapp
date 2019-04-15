package com.bbd.modisa.mapper;

import com.bbd.modisa.data.entities.User;
import com.bbd.modisa.model.UserDto;

public class UserMapper extends ModelMapper<UserDto, User> {
    @Override
    public UserDto dbToDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setUserId(user.getUserId());
        userDto.setfName(user.getfName());
        userDto.setlName(user.getlName());

        return userDto;
    }

    @Override
    public User dtoToDb(UserDto userDto) {
        User user = new User();

        user.setfName(userDto.getfName());
        user.setlName(userDto.getlName());

        return user;
    }
}
