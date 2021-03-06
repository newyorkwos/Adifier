package com.adifier.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @description: create OdTicket Ticket
 * @author: StevenWu
 * @create: 2019-04-03 15:02
 **/
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OdTicket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCancel;
    @ManyToOne
    private User user;

    //For Repository delete relation between OdTicket and User Table
    public void clearOdTicket(){
        this.getUser().getOdTickets().remove(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OdTicket() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Date getDateCancel() {
        return dateCancel;
    }

    public void setDateCancel(Date dateCancel) {
        this.dateCancel = dateCancel;
    }

    @Override
    public String toString() {
        return "OdTicket{" +
                "id=" + id +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                ", dateCancel=" + dateCancel +
                '}';
    }
}
