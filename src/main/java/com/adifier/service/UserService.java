package com.adifier.service;

import com.adifier.domain.User;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    User getOne(Long id);
    void deleteUser(Long id);
    User findByUsernameAndPassword(String username, String password);
}
