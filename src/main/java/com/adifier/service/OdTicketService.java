package com.adifier.service;

import com.adifier.domain.OdTicket;

import java.util.List;

public interface OdTicketService {
    OdTicket saveOdTicket(OdTicket odTicket);
    OdTicket updateOdTicket(OdTicket odTicket);
    List<OdTicket> findOdTickets(Long id);
    void deleteOdTicket(Long id);
}
