package com.dev.PhoneBook.cont;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.dev.PhoneBook.entity.ContactDetails;
import com.dev.PhoneBook.exception.NoDataFoundException;
import com.dev.PhoneBook.ser.ContactDetailsSerImpl;

import io.swagger.annotations.ApiOperation;

@RestController

//@Api("This is documentation for the phone book applicaion")
public class ContactController {

	private static final Logger logger = Logger.getLogger(ContactController.class);

	@Autowired
	private ContactDetailsSerImpl contactDetailsSerImpl;

	@ApiOperation("This method is used for the saving the data into the databases")
	@PostMapping("/save")

	public ResponseEntity<String> saveContactDetails(@RequestBody ContactDetails saveContactDetails) {

		logger.debug("*******saveContactDetails() method exiqution started ******");

		try {
			boolean savedContact = contactDetailsSerImpl.saveContactDetails(saveContactDetails);

			if (savedContact) {
				logger.info("*****saveContactDetails() contact saved sucssfully******");

				return new ResponseEntity<>("contacted saved sucssfully", HttpStatus.CREATED);

			}
		} catch (Exception e) {

			logger.error("****Exception ocuuer ::" + e.getMessage());
		}

		logger.info(" ******saveContactDetails() not saved contact ******");

		logger.debug("*****saveContactDetails() method exiquation stoped******");
		return new ResponseEntity<String>("contact not save due to error", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	// @ApiOperation("This is the method used for the get data from the data base")

	@GetMapping("/{contactId}")
	public ResponseEntity<ContactDetails> findById(@PathVariable(name = "contactId") Integer contactId) {

		logger.debug("********8findBy() method started *******");

		ContactDetails findContactDetailsById = null;

		try {
			findContactDetailsById = contactDetailsSerImpl.findContactDetailsById(contactId);
			if (findContactDetailsById == null) {

				logger.info("****contact detail not found*****");
				throw new NoDataFoundException("contact details not found");
			}
		} catch (Exception e) {
			logger.error("**** error accuerd due to ::" + e.getMessage());
		}

		logger.info("****** findBy() method return the contact details**** ");

		return new ResponseEntity<>(findContactDetailsById, HttpStatus.OK);

		/*
		 * if (findContactDetailsById != null) { return new
		 * ResponseEntity<>(findContactDetailsById, HttpStatus.OK); } else {
		 * 
		 * return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); }
		 */
	}

	@ApiOperation("this is the method used for the update the record in the database")

	@PutMapping("/update")
	public ResponseEntity<String> updateContactDetails(@RequestBody ContactDetails updateContactDetails) {
		logger.debug("**** updateContactDetails() method exiqution started ");
		if (updateContactDetails != null) {
			boolean updatedContact = contactDetailsSerImpl.updateContactDetails(updateContactDetails);
			if (updatedContact) {

				logger.info("**** contact details updated succesfully******");
				return new ResponseEntity<String>("contact updated sucssfully", HttpStatus.OK);
			} else {
				logger.info("*** contact details not updated *****");
				logger.info("**** update method is exiquction completed****");
				return new ResponseEntity<String>("contact not updated", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {

			return new ResponseEntity<String>("bad request", HttpStatus.BAD_REQUEST);
		}

	}

	// @ApiOperation("this is the method used for the getting all the data from the
	// data base")

	@GetMapping("/getAll")
	public ResponseEntity<List<ContactDetails>> findAllById() {

		logger.debug("**** findAll() method is exiquted *******8");

		List<ContactDetails> allContactDetails = null;

		try {

			allContactDetails = contactDetailsSerImpl.getAllContactDetails();

			logger.info("***** contact details are displayed *****8**");
		} catch (Exception e) {

			logger.error("exception occure ::" + e.getMessage());
		}
		logger.debug("***** findAll() method commpleted exiqution*****");
		return new ResponseEntity<>(allContactDetails, HttpStatus.OK);

	}

	// @ApiOperation("this is the method for the delete data ")

	@DeleteMapping("/{contactId}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "contactId") Integer contactId) {

		logger.debug("**** deleted method() exiqution started****");
		ResponseEntity<String> responseEntity = null;

		try {

			boolean deleteContactDetails = contactDetailsSerImpl.deleteContactDetails(contactId);

			if (deleteContactDetails) {

				logger.info("******contact was deleted****");

				responseEntity = new ResponseEntity<String>("contact was delete", HttpStatus.OK);

			}

		} catch (Exception e) {

			logger.error("***** error occuer ::" + e.getMessage());

		}

		logger.debug("********deleted method exiqution stopped*****");

		responseEntity = new ResponseEntity<String>("not deleted due to error", HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;

	}

}
