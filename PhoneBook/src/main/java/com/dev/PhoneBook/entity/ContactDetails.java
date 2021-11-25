package com.dev.PhoneBook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="CONTACT_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetails {
	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID")
	private Integer id;
	@Column(name="CONTACT_NAME")
	private String name;
	@Column(name="CONTACT_EMAIL")
	private String email;
	
	@Column(name="CONTACT_NUMBERS")
	private long number;

}
