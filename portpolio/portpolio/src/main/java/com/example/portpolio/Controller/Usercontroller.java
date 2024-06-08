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
    public List<UserDTO> getUsers(){
        return userservice.getallusers();
    }


    @PostMapping("/Adduser")
    public UserDTO Adduser( @RequestBody UserDTO userDTO ){
        return userservice.saveuser(userDTO);

    }
    @PutMapping("/updateUser")
    public  UserDTO Updateuser(@RequestBody UserDTO userDTO){
        return userservice.UpdateUser(userDTO);
    }


    @GetMapping("/user/{userId}")
    public UserDTO getUserById(@PathVariable Integer userId){
        return  userservice.getuserById(userId);
    }




    @DeleteMapping("/DeleteUser")
    public String Deleteuser(@RequestBody UserDTO userDTO){
        return userservice.deleteUser(userDTO);
    }


}
