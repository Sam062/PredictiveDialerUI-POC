package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.ContactDetails;

public interface ContactDetailsRepo extends JpaRepository<ContactDetails, Integer> {

}
