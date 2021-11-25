package com.dev.PhoneBook.ser;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dev.PhoneBook.entity.ContactDetails;
import com.dev.PhoneBook.exception.NoDataFoundException;
import com.dev.PhoneBook.repo.ContactRepo;

@Service
public class ContactDetailsSerImpl implements ContactSer {
	
@Autowired	
private ContactRepo contactrepo;
	
	

	

	@Override
	public boolean saveContactDetails(ContactDetails contactdetails) {
		
		ContactDetails save = contactrepo.save(contactdetails);
		
		return save.getId()!=null ? true : false;
	}

	@Override
	public boolean updateContactDetails(ContactDetails contactDetails) {
		
		ContactDetails update = contactrepo.save(contactDetails);
		
		return update.getId()!=null;
	}

	

	@Override
	public List<ContactDetails> getAllContactDetails() {
		// TODO Auto-generated method stub
		return contactrepo.findAll();
	}

	@Override
	public ContactDetails findContactDetailsById(Integer contactId) {
		
		Optional<ContactDetails> findById = contactrepo.findById(contactId);
		
		if(findById.isPresent()){
			
			return findById.get();
			
		}
		return null;
	}

	@Override
	public boolean deleteContactDetails(Integer contactId) {
		
		try {
			contactrepo.deleteById(contactId);
			return true;
			
		} catch (Exception e) {
			throw new NoDataFoundException("no data found for deleting the record");
		}
		
			}

	
}
 