package com.adifier.service;

import com.adifier.domain.OdTicket;

public interface OdTicketService {
    OdTicket saveOdTicket(OdTicket odTicket);
    void deleteOdTicket(Long id);
}
