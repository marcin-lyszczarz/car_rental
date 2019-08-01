package com.lyszczarzmarcin.portfolio.controller;

import com.lyszczarzmarcin.portfolio.model.Client;
import com.lyszczarzmarcin.portfolio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public Client addClient(@RequestBody Client client){
        return clientService.addOrUpdateClients(client);
    }

    @GetMapping
    public List<Client> list (){
        List<Client> clientList = clientService.getAllClient();
        return clientList;
    }

    @GetMapping("/{id}")
    public Client clientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id){
        clientService.deletaClient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Client editInfoClient(@PathVariable Long id, @RequestBody Client client){


        return clientService.addOrUpdateClients(client, id);
    }
}
