package com.picus.mailcampaignserver.controller;

import com.picus.mailcampaignserver.dto.MailDTO;
import com.picus.mailcampaignserver.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mail")
public class MailController implements IMailController {

    @Autowired
    private IMailService mailService;

    @PostMapping(value="/linkClicked")
    @ResponseBody
    @Override
    public void updateMail(@RequestBody String uuid){
        mailService.updateMail(uuid,LocalDateTime.now());
    }

    @GetMapping(value="/getMails")
    @ResponseBody
    @Override
    public List<MailDTO> getMails(@RequestParam("contactId") Integer contactId) {
        return mailService.getMails(contactId).stream().map(MailDTO::new).collect(Collectors.toList());
    }
}
