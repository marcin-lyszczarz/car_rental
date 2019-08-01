package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.Client;
import com.lyszczarzmarcin.portfolio.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;


    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }


    @Override
    public Client addOrUpdateClients(Client client) {
        return clientRepository.save(client);
    }

    public Client addOrUpdateClients(Client client, Long id) {
        Optional<Client> editClientOptional = clientRepository.findById(id);

        Client editClient = editClientOptional.get();

        if (client.getFirstName() != null)
            editClient.setFirstName(client.getFirstName());
        if (client.getLastName() != null)
            editClient.setLastName(client.getLastName());
        if (client.getAdress()!= null)
            editClient.setAdress(client.getAdress());
        if (client.getCity() != null)
            editClient.setCity(client.getCity());
        if (client.getEmail() != null)
            editClient.setEmail(client.getEmail());
        return clientRepository.save(client);
    }

    @Override
    public void deletaClient(Long id) {
        clientRepository.deleteById(id);
    }
}
