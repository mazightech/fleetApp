package com.maztech.fleet.services;

import com.maztech.fleet.entities.Client;
import com.maztech.fleet.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    //return list of Clients
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    //Save new client
    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public Client findClientById(int id){
        return clientRepository.findById(id).get();
    }


    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

}
