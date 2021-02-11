package com.restapi.restiwak.service;

import com.restapi.restiwak.pojo.User;
import com.restapi.restiwak.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public List<User> userList() {
        return this.userRepository.findAll();
    }

    public User loadByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public User get(Long id) {
        return (User)this.userRepository.findById(id).get();
    }

    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
