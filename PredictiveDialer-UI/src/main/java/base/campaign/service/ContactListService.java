package base.campaign.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.ContactDetails;
import base.entity.ContactList;
import base.repository.ContactDetailsRepo;
import base.repository.ContactListRepo;

@Service
public class ContactListService {

	@Autowired
	private ContactListRepo listRepo;

	@Autowired
	private ContactDetailsRepo contactDetailsRepo;

	public List<ContactList> getAllContactLists() {
		return listRepo.findAll();
	}

	public ContactList saveOrUpdateContactList(ContactList contactList) {
		return listRepo.save(contactList);
	}

	public boolean deleteContactList(ContactList contList) {
		try {
			listRepo.delete(contList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Optional<ContactList> findContactListById(Integer contactId) {
		return listRepo.findById(contactId);
	}

	public List<ContactDetails> getAllContactDetails() {
		return contactDetailsRepo.findAll();
	}

	public ContactDetails saveOrUpdateContactDetails(ContactDetails contDetails) {
		return contactDetailsRepo.save(contDetails);
	}

	public boolean deleteContact(ContactDetails contact) {
		try {
			contactDetailsRepo.delete(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Optional<ContactDetails> findContactDetailsById(Integer contactId) {
		return contactDetailsRepo.findById(contactId);
	}

}
