package com.anna.gymmembership.controller;

import com.anna.gymmembership.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MembershipController {
    @Autowired
    private MembershipService membershipService;
}
