package com.example.bp_2023_2024;

import com.example.bp_2023_2024.models.User;
import com.example.bp_2023_2024.models.UserRole;
import com.example.bp_2023_2024.repositories.UserRepository;
import com.example.bp_2023_2024.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Bp20232024ApplicationTests {
//    @Mock
//
//
//    private UserRepository userRepository;
//
//    @InjectMocks


   // private UserService userService;
    @Test
    void contextLoads() {
    }
//    @Test
//    public void testEditUser_success() {
//        // Arrange
//        User existingUser = new User(1L, "testUser", "testPassword", UserRole.ROLE_USER);
//        User updatedUser = new User(1L, "updatedUsername", "updatedPassword", UserRole.ROLE_ADMIN);
//        UserRole newRole = UserRole.ROLE_ADMIN;
//
//        // Act
//
//        User updatedUserAfterEdit = userService.updateUser(1L, updatedUser, newRole);
//
//        // Assert
//        assertEquals(updatedUserAfterEdit.getUserId(), updatedUser.getUserId());
//        assertEquals(updatedUserAfterEdit.getUsername(), updatedUser.getUsername());
//        assertEquals(updatedUserAfterEdit.getPassword(), updatedUser.getPassword());
//        assertEquals(updatedUserAfterEdit.getRole(), newRole);
//    }
}
