package com.adifier;

import com.adifier.domain.OdTicket;
import com.adifier.domain.User;
import com.adifier.service.UserService;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @description: create User Test
 * @author: StevenWu
 * @create: 2019-04-03 15:14
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {

    @Autowired
    private UserService userService;


    long id;
    // @Test
    public void asaveAuthorTest(){
        User user=new User();
        user.setUsername("TestMan2");
        user.setEmail("testMan2@adifier.com");
        user.setPassword("pass1234");
        user.setPhone("123456789");

        OdTicket odTicket1=new OdTicket();
        OdTicket odTicket2=new OdTicket();
        odTicket1.setDateCreate(new Date());
        odTicket2.setDateCreate(new Date());

        user.addOdTicket(odTicket1);
        user.addOdTicket(odTicket2);
        userService.saveUser(user);
        id=(userService.findByUsernameAndPassword("TestMan2","pass1234")).getId();
        System.out.println("******* the user id="+ id);


    }

    //@Test
    public void bupdateUser(){
        User user=userService.getOne(id);
        //System.out.println("The user= "+user.getUsername());
        user.setEmail("newTestmail@adifier.com");
        userService.updateUser(user);
    }

    //@Test
    public void cfindUser(){
        User user=userService.getOne(id);
        //System.out.println("****************"+user.getOdTickets());
        System.out.println("****************"+user.toString());
    }

    //@Test
    public void ddeleteUser(){
        userService.deleteUser(id);


    }


}
