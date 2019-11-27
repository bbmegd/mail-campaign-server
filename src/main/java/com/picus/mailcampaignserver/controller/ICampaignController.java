package com.picus.mailcampaignserver.controller;

import com.picus.mailcampaignserver.dto.CampaignDTO;

import java.util.List;

public interface ICampaignController {
    List<CampaignDTO> getAllCampaigns();

    List<CampaignDTO> getAllActiveCampaigns();

    void addCampaign(String campaignName);

    void cancelCampaign(List<Integer> idList);
}
