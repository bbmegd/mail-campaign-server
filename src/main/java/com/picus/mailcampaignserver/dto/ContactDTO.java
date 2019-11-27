package com.picus.mailcampaignserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.picus.mailcampaignserver.entity.Contact;

import java.io.Serializable;

public class ContactDTO implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Boolean isMailSent;
    private Boolean isLinkClicked;
    private Integer totalTime;

    public ContactDTO() {
    }

    public ContactDTO(Contact contact) {
        this.id=contact.getId();
        this.name=contact.getName();
        this.surname=contact.getSurname();
        this.email=contact.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMailSent() {
        return isMailSent;
    }

    public void setMailSent(Boolean mailSent) {
        isMailSent = mailSent;
    }

    public Boolean getLinkClicked() {
        return isLinkClicked;
    }

    public void setLinkClicked(Boolean linkClicked) {
        isLinkClicked = linkClicked;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    @JsonIgnore
    public Contact getDomainObject(){
        Contact contact = new Contact();
        contact.setId(this.id);
        contact.setName(this.name);
        contact.setSurname(this.surname);
        contact.setEmail(this.email);
        return contact;
    }
}
