package com.adifier;

import com.adifier.domain.OdTicket;
import com.adifier.domain.OdTicketRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OdTicketTest {
    @Autowired
    private OdTicketRepository odTicketRepository;

    @Test
    public void saveOdTest(){
        OdTicket odTicket=new OdTicket();
        odTicket.setDateCreate(new Date());
        odTicket.setDateUpdate(new Date());
        odTicket.setDateCancel(new Date());
        odTicketRepository.save(odTicket);
    }
}
