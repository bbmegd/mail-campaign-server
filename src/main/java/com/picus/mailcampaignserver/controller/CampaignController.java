package com.picus.mailcampaignserver.controller;

import com.picus.mailcampaignserver.dto.CampaignDTO;
import com.picus.mailcampaignserver.entity.Campaign;
import com.picus.mailcampaignserver.service.ICampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/campaign")
public class CampaignController implements ICampaignController {

    @Autowired
    private ICampaignService campaignService;

    @GetMapping(value="/getAllCampaigns")
    @ResponseBody
    @Override
    public List<CampaignDTO> getAllCampaigns(){
        return campaignService.getAllCampaigns().stream().map(CampaignDTO::new).collect(Collectors.toList());
    }

    @GetMapping(value="/getAllActiveCampaigns")
    @ResponseBody
    @Override
    public List<CampaignDTO> getAllActiveCampaigns(){
        return campaignService.getAllActiveCampaigns().stream().map(CampaignDTO::new).collect(Collectors.toList());
    }

    @PostMapping(value="/addCampaign",consumes = "text/plain")
    @ResponseBody
    @Override
    public void addCampaign(@RequestBody String campaignName){
        campaignService.addCampaign(new Campaign(campaignName));
    }

    @PostMapping(value="/cancelCampaign")
    @ResponseBody
    @Override
    public void cancelCampaign(@RequestBody List<Integer> idList){
        campaignService.cancelCampaign(idList);
    }

}
