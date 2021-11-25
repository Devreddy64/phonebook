package com.dev.PhoneBook.cont;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dev.PhoneBook.entity.ContactDetails;
import com.dev.PhoneBook.ser.ContactDetailsSerImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = ContactController.class)

public class ContactControllerTest {
	
	@MockBean
	private ContactDetailsSerImpl impl;
	
	@Autowired
	private MockMvc mock;
	
	@Test
	public void test_saveContactDetails() throws Exception {
		
		when(impl.saveContactDetails(Mockito.any())).thenReturn(true);
		
		
		ContactDetails contactdetails = new ContactDetails();
		
		ObjectMapper obj = new ObjectMapper();
		String json = null;
		try {
			json=obj.writeValueAsString(contactdetails);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		MockHttpServletRequestBuilder mrb = MockMvcRequestBuilders.post("/save").contentType("application/json").content(json);
		
		
		MvcResult result=mock.perform(mrb).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		int status = response.getStatus();
		
		assertEquals(201, status);
		
	}

}
