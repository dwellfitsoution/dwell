package com.dwell.service;

import com.dwell.entity.Client;
import com.dwell.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client getClientById(Integer customerId) {
        Optional<Client> clientById = clientRepository.findById(customerId);
        if (clientById.isPresent()) {
            return clientById.get();
        }
        return null;
    }
}
