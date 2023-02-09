package com.dwell.service;

import com.dwell.entity.CheckUp;
import com.dwell.entity.Client;
import com.dwell.entity.Coach;
import com.dwell.repository.ClientRepository;
import com.dwell.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;

    public Coach getCoachById(Integer coachId) {
        Optional<Coach> coachById = coachRepository.findById(coachId);
        if (coachById.isPresent()) {
            return coachById.get();
        }
        return null;
    }
}
