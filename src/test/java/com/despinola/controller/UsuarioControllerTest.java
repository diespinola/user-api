package com.despinola.controller;

import com.despinola.model.User;
import com.despinola.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UsuarioControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testCreateUser_ReturnsSavedUser() {
        // Arrange
        User inputUser = new User();
        inputUser.setName("Juan");
        inputUser.setEmail("juan@example.com");

        User savedUser = new User();
        savedUser.setUid(UUID.randomUUID());
        savedUser.setName("Juan");
        savedUser.setEmail("juan@example.com");

        when(userService.createUser(inputUser)).thenReturn(savedUser);

        // Act
        ResponseEntity<User> response = userController.createUser(inputUser);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(savedUser);

        verify(userService, times(1)).createUser(inputUser);
    }
}
