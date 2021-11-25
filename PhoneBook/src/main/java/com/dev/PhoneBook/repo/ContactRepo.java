package com.dev.PhoneBook.repo;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.dev.PhoneBook.entity.ContactDetails;
@Repository

public interface ContactRepo extends JpaRepository<ContactDetails, Serializable> {

	
}
