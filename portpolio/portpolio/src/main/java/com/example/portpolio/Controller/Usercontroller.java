package com.example.portpolio.Controller;


import com.example.portpolio.dto.UserDTO;
import com.example.portpolio.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api/V1/")
@CrossOrigin
@RestController
public class Usercontroller {

    @Autowired
    private Userservice userservice;


    @GetMapping("/getuser")
    public List<UserDTO> getUser(){
        return userservice.getallusers();
    }


    @PostMapping("/Adduser")
    public UserDTO Adduser( @RequestBody UserDTO userDTO ){
        return userservice.saveuser(userDTO);

    }

}
