package com.picus.mailcampaignserver.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="mail")
public class Mail {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="isLinkClicked")
    private Boolean isLinkClicked;

    @Column(name="startTime")
    private LocalDateTime startTime;

    @Column(name="endTime")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "contact_id",nullable = false)
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "campaign_id",nullable = false)
    private Campaign campaign;

    @Column(name="uuid")
    private String uuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getLinkClicked() {
        return isLinkClicked;
    }

    public void setLinkClicked(Boolean linkClicked) {
        isLinkClicked = linkClicked;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
