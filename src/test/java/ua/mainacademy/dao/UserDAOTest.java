package ua.mainacademy.dao;

import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.mainacademy.model.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    void createAndDeleteUser() {
        User user = User.builder()
                .login("test_login")
                .password("test_pass")
                .firstName("f_name")
                .lastName("l_name")
                .phone("+380505555555")
                .email("my.email@mail.com")
                .build();
        User savedUser = userDAO.save(user);

        assertNotNull(savedUser.getId());

        userDAO.delete(savedUser);
    }
}