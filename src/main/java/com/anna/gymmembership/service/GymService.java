package com.anna.gymmembership.service;

import com.anna.gymmembership.repository.GymRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService {
    @Autowired
    private GymRepo gymRepo;
}
