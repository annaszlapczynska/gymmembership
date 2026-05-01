package com.anna.gymmembership.controller;

import com.anna.gymmembership.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymController {
    @Autowired
    private GymService gymService;
}
