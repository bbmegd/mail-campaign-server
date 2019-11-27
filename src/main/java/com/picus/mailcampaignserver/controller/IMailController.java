package com.picus.mailcampaignserver.controller;

import com.picus.mailcampaignserver.dto.MailDTO;

import java.util.List;

public interface IMailController {
    void updateMail(String uuid);

    List<MailDTO> getMails(Integer contactId);
}
