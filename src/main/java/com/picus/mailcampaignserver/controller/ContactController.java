package com.picus.mailcampaignserver.controller;

import com.picus.mailcampaignserver.dto.ContactDTO;
import com.picus.mailcampaignserver.dto.EmailDTO;
import com.picus.mailcampaignserver.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/contact")
public class ContactController implements IContactController{

    @Autowired
    private IContactService contactService;

    @PostMapping(value="/uploadFile",consumes = "multipart/form-data")
    @ResponseBody
    @Override
    public void fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        contactService.parseFileAndSaveContacts(file);
    }

    @GetMapping(value="/getAllContacts")
    @ResponseBody
    @Override
    public List<ContactDTO> getAllContacts(){
        return contactService.getAllContacts().stream().map(ContactDTO::new).collect(Collectors.toList());
    }

    @PostMapping(value="/sendEmail",consumes = "application/json")
    @ResponseBody
    @Override
    public void sendEmail(@RequestBody EmailDTO emailDTO){
        contactService.sendEmail(
                Arrays.stream(emailDTO.getContacts()).map(ContactDTO::getDomainObject).collect(Collectors.toList()),
                emailDTO.getMessage(),emailDTO.getCampaign().getDomainObject());
    }

    @DeleteMapping(value="/deleteContact")
    @ResponseBody
    @Override
    public void deleteContact(@RequestParam("idList") List<Integer> idList){
        contactService.deleteContact(idList);
    }

    @PostMapping(value="/addContact",consumes = "application/json")
    @ResponseBody
    @Override
    public void sendEmail(@RequestBody ContactDTO contactDTO){
        contactService.addContact(contactDTO.getDomainObject());
    }
}
