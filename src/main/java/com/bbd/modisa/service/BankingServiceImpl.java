package com.bbd.modisa.service;

import com.bbd.modisa.data.entities.User;
import com.bbd.modisa.data.service.BankingDataService;
import com.bbd.modisa.data.model.UserDto;
import com.bbd.modisa.mapper.UserMapper;

import javax.ejb.Stateless;

@Stateless
public class BankingServiceImpl implements BankingService {
    private BankingDataService bankingDataService = new BankingDataService();
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();

        //userMapper.dtoToDb(userDto);
        user.setlName(userDto.getlName());
        user.setfName(userDto.getfName());
        bankingDataService.createUser(user);

        return userDto;
    }
}
