package com.picus.mailcampaignserver.service;

import com.picus.mailcampaignserver.entity.Campaign;
import com.picus.mailcampaignserver.entity.Contact;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface IContactService {
    void parseFileAndSaveContacts(MultipartFile file) throws IOException;

    List<Contact> getAllContacts();

    void sendEmail(List<Contact> contactList, String message, Campaign campaign);

    void deleteContact(List<Integer> idList);

    void addContact(Contact contact);
}
