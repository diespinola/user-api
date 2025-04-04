package com.despinola.service.impl;

import com.despinola.entities.UserEntity;
import com.despinola.mapper.UserMapper;
import com.despinola.model.User;
import com.despinola.repository.UserRepository;
import com.despinola.security.JwtUtil;
import com.despinola.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

    @Override
    public User createUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        UserEntity userEntity = userMapper.toEntity(user);
        userEntity.setToken(jwtUtil.generateToken(user.getEmail()));
        userEntity.setIsActive(true);

        if (userEntity.getPhones() != null) {
            userEntity.getPhones().forEach(phone -> phone.setUser(userEntity));
        }

        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toModel(savedUser);
    }
}
