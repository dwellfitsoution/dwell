package com.dwell.controller;

import com.dwell.entity.Client;
import com.dwell.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkups")
public class CheckupController {
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{customerId}")
    public Client getCheckUpInfo(@PathVariable Integer customerId) {
        Client clientById = clientService.getClientById(customerId);
        return clientById;
    }
}
