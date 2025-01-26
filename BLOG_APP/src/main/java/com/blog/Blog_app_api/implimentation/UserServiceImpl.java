package com.blog.Blog_app_api.implimentation;
import com.blog.Blog_app_api.dto.UserDto;
import com.blog.Blog_app_api.entity.User;
import com.blog.Blog_app_api.exception.ResourceNotFoundException;
import com.blog.Blog_app_api.repositories.UserRepository;
import com.blog.Blog_app_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class UserServiceImpl implements UserService {


    @Autowired
    private   UserRepository userRepo;
    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user=this.UserdtoToUser(userDto);

        User saveUser=this.userRepository.save(user);
        return this.userToUserDto(saveUser );

    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user=this.userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User","Id",userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updateUser=this.userRepository.save(user);

        return userToUserDto(updateUser);


    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user=this.userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User","Id",userId)
        );

         return  this.userToUserDto(user);
    }

//    @Override
//    public List<UserDto> getAllUsers() {
//
//
//        List<User> userList=this.userRepository.findAll();
//
//        return userList.stream().map(this::userToUserDto).collect(Collectors.toList());
//    }

//    @Override
//    public List<UserDto> getAllUser() {
//        List<User>userList=this.userRepository.findAll();
//
//        List<UserDto> userDtoList=userList.stream().map(this::userToUserDto).collect(Collectors.toList());
//        return userDtoList;
//    }

    @Override
    public void deleteUser(Integer userId) {
         User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
           this.userRepository.delete(user);
    }

    private User UserdtoToUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setAbout(userDto.getAbout());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        return  user;
    }
    private  UserDto userToUserDto(User user){
         UserDto userDto=new UserDto();

         userDto.setAbout(user.getAbout());
         userDto.setId(user.getId());
         userDto.setName(user.getName());
         userDto.setEmail(user.getEmail());
         userDto.setPassword(user.getPassword());

        return  userDto;
    }
}
