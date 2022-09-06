package base.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import base.campaign.service.ContactListService;
import base.entity.ContactDetails;
import base.entity.ContactList;
import base.util.DialerConstants;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/contacts/")
public class ContactListConroller {

	@Autowired
	private ContactListService contactListService;

	@GetMapping("/getAllContactLists")
	public ResponseEntity<List<ContactList>> getAllContactLists() {
		List<ContactList> contList = contactListService.getAllContactLists();
		System.out.println("getAllCampaigns() returning :: " + contList);

		Collections.sort(contList, (a,b)->b.getCreatedDate().compareTo(a.getCreatedDate()));
		if (contList != null)
			return new ResponseEntity<List<ContactList>>(contList, HttpStatus.OK);
		else
			return new ResponseEntity<List<ContactList>>(contList, HttpStatus.BAD_REQUEST);

	}

	@PostMapping(value = "/saveOrUpdateContactList")
	public ResponseEntity<String> saveOrUpdateContactList(@RequestBody ContactList contactList) {
		if (contactList != null) {
			ContactList status = contactListService.saveOrUpdateContactList(contactList);
			if (status != null && status.getContactListId() != null)
				return new ResponseEntity<String>(DialerConstants.SUCCESS, HttpStatus.CREATED);
			else
				return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.OK);
		}
		return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteContactList/{contactListId}")
	public ResponseEntity<String> deleteCampaign(@PathVariable("contactListId") Integer contactListId) {
		if (contactListId != null) {
			boolean isDeleted = contactListService.findContactListById(contactListId)
					.map(contactListService::deleteContactList).orElse(false);

			if (isDeleted)
				return new ResponseEntity<String>(DialerConstants.SUCCESS, HttpStatus.OK);
			else
				return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.OK);
		}
		return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAllContactDetails")
	public ResponseEntity<List<ContactDetails>> getAllContactDetails() {
		List<ContactDetails> contactDetailsList = contactListService.getAllContactDetails();
		System.out.println("getAllContactDetails() returning :: " + contactDetailsList);

		if (contactDetailsList != null)
			return new ResponseEntity<List<ContactDetails>>(contactDetailsList, HttpStatus.OK);
		else
			return new ResponseEntity<List<ContactDetails>>(contactDetailsList, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/saveOrUpdateContactDetails")
	public ResponseEntity<String> saveOrUpdateContactDetails(@RequestBody ContactDetails contactDetails) {
		if (contactDetails != null) {
			ContactDetails status = contactListService.saveOrUpdateContactDetails(contactDetails);
			if (status != null && status.getContactId() != null)
				return new ResponseEntity<String>(DialerConstants.SUCCESS, HttpStatus.CREATED);
			else
				return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.OK);
		}
		return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteContactDetail/{contactId}")
	public ResponseEntity<String> deleteCampaignSetting(@PathVariable("contactId") Integer contactId) {
		if (contactId != null) {
			boolean isDeleted = contactListService.findContactDetailsById(contactId)
					.map(contactListService::deleteContact).orElse(false);

			if (isDeleted)
				return new ResponseEntity<String>(DialerConstants.SUCCESS, HttpStatus.OK);
			else
				return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.OK);
		}
		return new ResponseEntity<String>(DialerConstants.FAILURE, HttpStatus.BAD_REQUEST);
	}

}
