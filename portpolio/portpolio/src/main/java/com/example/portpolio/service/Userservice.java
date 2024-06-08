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
}
