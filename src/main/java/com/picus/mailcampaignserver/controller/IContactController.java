package com.picus.mailcampaignserver.controller;

import com.picus.mailcampaignserver.dto.ContactDTO;
import com.picus.mailcampaignserver.dto.EmailDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IContactController {
    void fileUpload(MultipartFile file) throws IOException;
    List<ContactDTO> getAllContacts();
    void sendEmail(EmailDTO emailDTO);
    void deleteContact(List<Integer> idList);
    void sendEmail(ContactDTO contactDTO);
}
