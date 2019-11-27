package com.picus.mailcampaignserver.service;

import com.picus.mailcampaignserver.entity.Campaign;
import com.picus.mailcampaignserver.entity.Contact;
import com.picus.mailcampaignserver.entity.Mail;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IMailService {
    void updateMail(String uuid, LocalDateTime endTime);

    void saveNewMail(Campaign campaign, Contact contact, UUID uuid);

    List<Mail> getMails(Integer contactId);
}
