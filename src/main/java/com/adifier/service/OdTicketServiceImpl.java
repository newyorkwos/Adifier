package com.adifier.service;

import com.adifier.domain.OdTicket;
import com.adifier.domain.OdTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OdTicketServiceImpl implements OdTicketService {

    @Autowired
    private OdTicketRepository odTicketRepository;

    @Transactional
    @Override
    public OdTicket saveOdTicket(OdTicket odTicket) {
        return odTicketRepository.save(odTicket);
    }

    @Transactional
    @Override
    public void deleteOdTicket(Long id) {
        OdTicket odTicket=odTicketRepository.getOne(id);
        odTicket.clearOdTicket();
        odTicketRepository.deleteById(id);
    }
}
