package com.despinola.service.impl;

import com.despinola.entities.UserEntity;
import com.despinola.entities.UserPhonesEntity;
import com.despinola.mapper.UserMapper;
import com.despinola.model.User;
import com.despinola.model.UserResponse;
import com.despinola.repository.UserRepository;
import com.despinola.security.JwtUtil;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserServiceImpl userService;

    private AutoCloseable closeable;

    private User user;
    private UserEntity userEntity;
    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);

        user = Instancio.create(User.class);
        userEntity = Instancio.create(UserEntity.class);
        userEntity.setPhones(List.of(new UserPhonesEntity()));
        userResponse = Instancio.create(UserResponse.class);

        user.setEmail("test@example.com");
        userEntity.setEmail("test@example.com");
        userResponse.setEmail("test@example.com");
    }

    @Test
    void createUser_successfullyCreatesUser() {
        // Given
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(userMapper.toEntity(user)).thenReturn(userEntity);
        when(jwtUtil.generateToken(user.getEmail())).thenReturn("mocked-jwt");
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userMapper.toUserResponse(userEntity)).thenReturn(userResponse);

        UserResponse result = userService.createUser(user);

        assertNotNull(result);
        assertEquals(user.getEmail(), result.getEmail());
        verify(userRepository).existsByEmail(user.getEmail());
        verify(jwtUtil).generateToken(user.getEmail());
        verify(userRepository).save(userEntity);
        verify(userMapper).toUserResponse(userEntity);
    }

    @Test
    void createUser_throwsExceptionWhenEmailExists() {
        // Given
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);

        // Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.createUser(user)
        );

        assertEquals("El correo ya está registrado.", exception.getMessage());
        verify(userRepository, never()).save(any());
        verify(userMapper, never()).toEntity((User) any());
    }

}
