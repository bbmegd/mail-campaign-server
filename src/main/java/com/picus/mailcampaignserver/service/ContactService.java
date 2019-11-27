package com.picus.mailcampaignserver.service;

import com.picus.mailcampaignserver.entity.Campaign;
import com.picus.mailcampaignserver.entity.Contact;
import com.picus.mailcampaignserver.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;

@Service
public class ContactService implements IContactService {

    @Autowired
    private IContactRepository contactRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private IMailService mailService;

    @Override
    public void parseFileAndSaveContacts(MultipartFile file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        while(reader.ready()){
            contactRepository.save(createContact(reader.readLine()));
        }
    }

    private Contact createContact(String row) {
        String[] rowTokens=row.split(" ");
        int countTokens = rowTokens.length;

        Contact contact=new Contact();
        contact.setName(getNameBuilder(rowTokens, countTokens));
        contact.setSurname(rowTokens[countTokens-2]);
        contact.setEmail(getEmail(rowTokens[countTokens - 1]));
        return contact;
    }

    private String getNameBuilder(String[] rowTokens, int countTokens) {
        StringBuilder nameBuilder=new StringBuilder();
        for(int i=0;i<countTokens-2;i++){
            nameBuilder.append(rowTokens[i]);
            nameBuilder.append(" ");
        }
        return nameBuilder.toString();
    }

    private String getEmail(String rowToken) {
        String email = rowToken;
        email=email.replace("<","");
        email=email.replace(">","");
        return email;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.getAllContacts();
    }

    @Transactional
    @Override
    public void sendEmail(List<Contact> contactList, String message, Campaign campaign) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        for (Contact contact : contactList) {
            UUID uuid = UUID.randomUUID();
            mailService.saveNewMail(campaign, contact, uuid);

            simpleMailMessage.setSubject(campaign.getName());
            simpleMailMessage.setTo(contact.getEmail());
            message=message + "\n" + "http://localhost:4200/link/"+uuid;
            simpleMailMessage.setText(message);
            javaMailSender.send(simpleMailMessage);
        }
    }

    @Override
    public void deleteContact(List<Integer> idList) {
        contactRepository.deleteByIdList(idList.toArray());
    }

    @Override
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }
}
