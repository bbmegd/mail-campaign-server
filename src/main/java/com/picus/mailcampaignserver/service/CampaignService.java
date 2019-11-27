package com.picus.mailcampaignserver.service;

import com.picus.mailcampaignserver.entity.Campaign;
import com.picus.mailcampaignserver.repository.ICampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CampaignService implements ICampaignService {

    @Autowired
    private ICampaignRepository campaignRepository;

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.getAllCampaigns();
    }

    @Transactional
    @Override
    public void addCampaign(Campaign campaign) {
        campaignRepository.save(campaign);
    }

    @Transactional
    @Override
    public void cancelCampaign(List<Integer> idList) {
        List<Campaign> campaignList = (List<Campaign>) campaignRepository.findAllById(idList);
        for (Campaign campaign : campaignList) {
            campaign.setActive(false);
        }
    }

    @Override
    public List<Campaign> getAllActiveCampaigns() {
        return campaignRepository.getAllActiveCampaigns();
    }
}
