package com.anna.gymmembership.service;

import com.anna.gymmembership.repository.MembershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipService {
    @Autowired
    private MembershipRepo membershipRepo;
}
