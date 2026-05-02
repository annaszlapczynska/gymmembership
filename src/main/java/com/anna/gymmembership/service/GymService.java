package com.anna.gymmembership.service;

import com.anna.gymmembership.entity.Gym;
import com.anna.gymmembership.repository.GymRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {
    @Autowired
    private GymRepo gymRepo;

    public Gym createGym(Gym gym) {
        return gymRepo.save(gym);
    }

    public List<Gym> getAllGyms() {
        return gymRepo.findAll();
    }
}
