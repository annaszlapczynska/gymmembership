package com.anna.gymmembership.service;

import com.anna.gymmembership.entity.Gym;
import com.anna.gymmembership.entity.GymMembership;
import com.anna.gymmembership.repository.GymRepo;
import com.anna.gymmembership.repository.MembershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipService {
    @Autowired
    private MembershipRepo membershipRepo;
    @Autowired
    private GymRepo gymRepo;

    public GymMembership createMembership(Long gymId, GymMembership gymMembership) {
        Gym gym = gymRepo.findById(gymId)
                .orElseThrow(() -> new RuntimeException("Gym not found"));

        gymMembership.setGym(gym);
        return membershipRepo.save(gymMembership);
    }

    public List<GymMembership> getMembershipsByGymId(Long gymId) {
        return membershipRepo.findByGymId(gymId);
    }
}
