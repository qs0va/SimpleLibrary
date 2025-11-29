/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.dynamika.testtask.sb.simplelibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dynamika.testtask.sb.simplelibrary.models.Client;
import ru.dynamika.testtask.sb.simplelibrary.repositories.ClientRepository;

/**
 *
 * @author qs0va_
 */
@Service
@Transactional(readOnly = true)
public class ClientService {

    private final ClientRepository clientRepo;

    @Autowired
    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Iterable<Client> getAllClients() {
        return clientRepo.findAll();
    }

    public Object findCLient(Long id) {
        return clientRepo.findById(id).get();
    }

    @Transactional
    public Long createClient(Client client) {
        clientRepo.save(client);
        return client.getId();
    }

    @Transactional
    public void updateClient(Long id, Client client) {
        client.setId(id);
        clientRepo.save(client);
    }
}
