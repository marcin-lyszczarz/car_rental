package com.lyszczarzmarcin.portfolio.service;


import com.lyszczarzmarcin.portfolio.model.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClient();
    public Client getClientById(Long id);
    public Client addOrUpdateClients(Client client);
    public void deletaClient(Long id);
    public Client addOrUpdateClients(Client client, Long id);
}
