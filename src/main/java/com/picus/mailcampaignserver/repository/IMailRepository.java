package com.picus.mailcampaignserver.repository;

import com.picus.mailcampaignserver.entity.Mail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMailRepository extends CrudRepository<Mail, Integer> {

    Mail findByUuid(String uuid);

    @Query(value = "select * from mail m where m.contact_id =?1", nativeQuery = true)
    List<Mail> findByContactId(Integer contact_id);
}
