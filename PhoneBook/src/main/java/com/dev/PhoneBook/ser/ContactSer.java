package com.dev.PhoneBook.ser;

import java.util.List;
import java.util.Optional;



import com.dev.PhoneBook.entity.ContactDetails;



public interface ContactSer {

	
	public boolean saveContactDetails(ContactDetails contactdetails);	
		

	public boolean updateContactDetails(ContactDetails contactDetails);
		
	
	public ContactDetails findContactDetailsById(Integer contactId );
		
		
	public List<ContactDetails>	getAllContactDetails();
		

	public boolean  deleteContactDetails(Integer contactId); 
		
		
	
	

}
