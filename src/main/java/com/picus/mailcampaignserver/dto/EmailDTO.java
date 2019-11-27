package com.picus.mailcampaignserver.dto;

public class EmailDTO {
    private ContactDTO[] contacts;
    private String message;
    private CampaignDTO campaign;

    public ContactDTO[] getContacts() {
        return contacts;
    }

    public void setContacts(ContactDTO[] contacts) {
        this.contacts = contacts;
    }

    public CampaignDTO getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDTO campaign) {
        this.campaign = campaign;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
