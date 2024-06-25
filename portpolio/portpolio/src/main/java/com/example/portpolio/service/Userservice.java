package com.example.portpolio.service;

import com.example.portpolio.dto.UserDTO;
import com.example.portpolio.model.User;
import com.example.portpolio.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Userservice {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    public List<UserDTO> getallusers(){
        List<User>userList= userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public  UserDTO saveuser( UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));

        return userDTO;
    }

    public UserDTO UpdateUser( UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public String  deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return  "User Successfully deleted ";
    }

    public UserDTO getuserById(Integer userId){
        User user = userRepo.getuserByid(userId);
        return modelMapper.map(user, UserDTO.class);
    }
}
