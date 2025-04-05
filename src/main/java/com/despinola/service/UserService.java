package com.despinola.service;

import com.despinola.model.User;
import com.despinola.model.UserResponse;

public interface UserService {
    UserResponse createUser(User user);
}
