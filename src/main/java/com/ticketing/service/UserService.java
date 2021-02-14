package com.ticketing.service;

import com.ticketing.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String> {

    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();


    //save
    //findBy user by username
    //give me all user list
    //delete
//    UserDTO save(UserDTO user);
//    UserDTO findById(String username);
//    List<UserDTO> findAll();
//    void delete (UserDTO user);
//    void deleteById(String username);
}
