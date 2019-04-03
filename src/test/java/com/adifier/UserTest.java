package com.adifier;

import com.adifier.domain.User;
import com.adifier.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: create User Test
 * @author: StevenWu
 * @create: 2019-04-03 15:14
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveAuthorTest(){
        User user=new User();
        user.setUsername("TestMan");
        user.setEmail("testMan@adifier.com");
        user.setPassword("pass1234");
        user.setPhone("123456789");
        userRepository.save(user);
    }

}
