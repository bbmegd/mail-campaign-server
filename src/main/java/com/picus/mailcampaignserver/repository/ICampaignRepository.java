package com.picus.mailcampaignserver.repository;

import com.picus.mailcampaignserver.entity.Campaign;
import com.picus.mailcampaignserver.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICampaignRepository extends CrudRepository<Campaign, Integer> {

    @Query("select c from campaign c")
    List<Campaign> getAllCampaigns();

    @Query("select c from campaign c where c.active=true")
    List<Campaign> getAllActiveCampaigns();
}
