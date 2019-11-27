package com.picus.mailcampaignserver.service;

import com.picus.mailcampaignserver.entity.Campaign;

import java.util.Arrays;
import java.util.List;

public interface ICampaignService {
    List<Campaign> getAllCampaigns();

    void addCampaign(Campaign campaign);

    void cancelCampaign(List<Integer> idList);

    List<Campaign> getAllActiveCampaigns();
}
