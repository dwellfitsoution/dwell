package com.dwell.controller;

import com.dwell.entity.Coach;
import com.dwell.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coaches")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @GetMapping(value = "/{coachId}")
    public Coach getCheckUpInfo(@PathVariable Integer coachId) {
        Coach coachById = coachService.getCoachById(coachId);
        return coachById;
    }
}
