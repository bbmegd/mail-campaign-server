package com.picus.mailcampaignserver.service;

import com.picus.mailcampaignserver.entity.Campaign;
import com.picus.mailcampaignserver.entity.Contact;
import com.picus.mailcampaignserver.entity.Mail;
import com.picus.mailcampaignserver.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MailService implements IMailService {

    @Autowired
    private IMailRepository mailRepository;

    @Transactional
    @Override
    public void updateMail(String uuid, LocalDateTime endTime) {
        Mail mail = mailRepository.findByUuid(uuid);
        if(mail==null){
            throw new UnsupportedOperationException("This id is not valid!");
        }
        mail.setEndTime(endTime);
        mail.setLinkClicked(true);
    }

    @Transactional
    @Override
    public void saveNewMail(Campaign campaign, Contact contact, UUID uuid) {
        Mail mail = new Mail();
        mail.setCampaign(campaign);
        mail.setContact(contact);
        mail.setStartTime(LocalDateTime.now());
        mail.setUuid(uuid.toString());
        mailRepository.save(mail);
    }

    @Override
    public List<Mail> getMails(Integer contactId) {
        return mailRepository.findByContactId(contactId);
    }
}
