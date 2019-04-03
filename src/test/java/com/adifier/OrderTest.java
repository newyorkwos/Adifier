package com.adifier;

import com.adifier.domain.Order;
import com.adifier.domain.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @description: create Order Test
 * @author: StevenWu
 * @create: 2019-04-03 15:59
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void saveOrderTest(){
        Order order=new Order();
        order.setCreateDate(new Date());
        order.setUpdateDate(new Date());
        order.setCreateDate(new Date());
    }
}
