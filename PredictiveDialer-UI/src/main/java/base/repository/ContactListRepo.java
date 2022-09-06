package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.ContactList;

public interface ContactListRepo extends JpaRepository<ContactList, Integer> {

}
