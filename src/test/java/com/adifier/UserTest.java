package com.adifier;

import com.adifier.domain.User;
import com.adifier.service.UserService;
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
    private UserService userService;



//    @Test
//    public void saveAuthorTest(){
//        User user=new User();
//        user.setUsername("TestMan2");
//        user.setEmail("testMan2@adifier.com");
//        user.setPassword("pass1234");
//        user.setPhone("123456789");
//
//        OdTicket odTicket1=new OdTicket();
//        OdTicket odTicket2=new OdTicket();
//        odTicket1.setDateCreate(new Date());
//        odTicket2.setDateCreate(new Date());
//
//        user.addOdTicket(odTicket1);
//        user.addOdTicket(odTicket2);
//        userService.saveUser(user);
//    }

    @Test
    public void updateUser(){
        User user=userService.getOne(23L);
        //System.out.println("The user= "+user.getUsername());
        user.setEmail("newTestmail@adifier.com");
        userService.updateUser(user);
    }

    @Test
    public void findUser(){
        User user=userService.getOne(23L);
        //System.out.println("****************"+user.getOdTickets());
        System.out.println("****************"+user.toString());
    }

    @Test
    public void deleteUser(){
        userService.deleteUser(23L);


    }


}
