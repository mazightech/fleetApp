package com.maztech.fleet.services;

import com.maztech.fleet.entities.Contact;
import com.maztech.fleet.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    //return list of Contacts
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    //Save new contact
    public void saveContact(Contact contact){
        contactRepository.save(contact);
    }

    public Contact findContactById(int id){
        return contactRepository.findById(id).get();
    }


    public void deleteContact(int id) {
        contactRepository.deleteById(id);
    }
    
}
