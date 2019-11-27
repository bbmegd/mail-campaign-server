package com.picus.mailcampaignserver.repository;

        import com.picus.mailcampaignserver.entity.Contact;
        import org.springframework.data.jpa.repository.Modifying;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import javax.transaction.Transactional;
        import java.util.List;

@Repository
public interface IContactRepository extends CrudRepository<Contact, Integer> {

    @Query("select c from contact c")
    List<Contact> getAllContacts();

    @Modifying
    @Transactional
    @Query("delete from contact c where c.id in ?1")
    void deleteByIdList(Object[] idList);
}
