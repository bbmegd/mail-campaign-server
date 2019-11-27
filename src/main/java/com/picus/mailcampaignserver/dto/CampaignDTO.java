package com.picus.mailcampaignserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.picus.mailcampaignserver.entity.Campaign;

import java.io.Serializable;

public class CampaignDTO implements Serializable {
    private Integer id;
    private String name;
    private Boolean active;

    public CampaignDTO() {
    }

    public CampaignDTO(Campaign campaign) {
        this.id=campaign.getId();
        this.name=campaign.getName();
        this.active=campaign.getActive();
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonIgnore
    public Campaign getDomainObject(){
        Campaign campaign = new Campaign();
        campaign.setId(this.id);
        campaign.setName(this.name);
        campaign.setActive(this.active);
        return campaign;
    }

}
