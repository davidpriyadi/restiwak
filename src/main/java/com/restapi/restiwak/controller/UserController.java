package com.restapi.restiwak.controller;

import com.restapi.restiwak.pojo.User;
import com.restapi.restiwak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping({"/user"})
    public List<User> listAll() {
        return this.userService.userList();
    }

    @GetMapping({"/user/{email}"})
    public User getUser(@PathVariable String email) {
        return this.userService.loadByEmail(email);
    }

    @PostMapping({"/user/save"})
    public String save(@RequestBody User user) {
        User userCek = this.userService.loadByEmail(user.getEmail());
        if (userCek != null) {
            String respon = "Email Sudah Terdaftar";
            return "Email Sudah Terdaftar";
        } else {
            this.userService.save(user);
            return "Berhasil";
        }
    }
}

