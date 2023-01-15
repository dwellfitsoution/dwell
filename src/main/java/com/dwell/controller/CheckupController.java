package com.dwell.controller;

import com.dwell.entity.CheckUp;
import com.dwell.entity.Client;
import com.dwell.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class CheckupController {
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{customerId}")
    public Client getCheckUpInfo(@PathVariable Integer customerId) {
        Client clientById = clientService.getClientById(customerId);
        return clientById;
    }

    @PostMapping(value = "/{customerId}")
    public String saveCheckUp(@PathVariable Integer customerId, @RequestBody CheckUp checkUp) {
        clientService.saveCheckUp(customerId, checkUp);
        return "Save Record!";
    }
}
