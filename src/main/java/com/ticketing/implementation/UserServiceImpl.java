package com.ticketing.implementation;

import com.ticketing.dto.UserDTO;
import com.ticketing.entitiy.User;
import com.ticketing.mapper.UserMapper;
import com.ticketing.repository.UserRepository;
import com.ticketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    UserRepository userRepository;
    UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> list = userRepository.findAll(Sort.by("firstName"));

        return list.stream().map(obj -> {return userMapper.convertToDto(obj);}).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        User user = userRepository.findByUserName(username);
        return userMapper.convertToDto(user);
    }

    @Override
    public void save(UserDTO dto) {
        User obj = userMapper.convertToEntity(dto);
        userRepository.save(obj);
    }

    @Override
    public UserDTO update(UserDTO dto) {
        //1->find current user
        User user = userRepository.findByUserName(dto.getUserName());
        //2->map update user dto to entity object
        User convertUser = userMapper.convertToEntity(dto);
        //3->set id to the converted object
        convertUser.setId(user.getId());
        //4-> save updated user
        userRepository.save(convertUser);
        return findByUserName(dto.getUserName());
    }

    @Override
    public void delete(String username) {
        User user = userRepository.findByUserName(username);
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    //hard delete
    @Override
    public void deleteByUserName(String username) {
        userRepository.deleteByUserName(username);
    }
}
