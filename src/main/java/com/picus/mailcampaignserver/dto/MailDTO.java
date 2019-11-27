package com.picus.mailcampaignserver.dto;

import com.picus.mailcampaignserver.entity.Campaign;
import com.picus.mailcampaignserver.entity.Contact;
import com.picus.mailcampaignserver.entity.Mail;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class MailDTO {

    private Integer id;

    private Boolean isLinkClicked;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String campaignName;

    private String uuid;

    public MailDTO() {
    }

    public MailDTO(Mail mail) {
        this.id=mail.getId();
        this.isLinkClicked=mail.getLinkClicked();
        this.startTime=mail.getStartTime();
        this.endTime=mail.getEndTime();
        this.campaignName=mail.getCampaign().getName();
        this.uuid=mail.getUuid();
    }

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

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
