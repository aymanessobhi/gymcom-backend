package com.ideracloud.gymcom.service;

import com.ideracloud.gymcom.dto.Pager;
import com.ideracloud.gymcom.dto.SearchRequest;
import com.ideracloud.gymcom.dto.UserDto;
import com.ideracloud.gymcom.dto.UserSearchDto;

import java.util.List;


public interface UserService {
    List<UserDto> listUsers();
    UserDto createUser (UserDto dto);
    UserDto updateUser(UserDto dto);
    UserDto findUserById(Long id);
    Integer countUsers();
    Pager<UserDto> searchUser(SearchRequest<UserSearchDto> query);
    UserDto save(UserDto user);
}
