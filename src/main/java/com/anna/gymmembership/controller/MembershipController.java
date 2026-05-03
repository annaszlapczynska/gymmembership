package com.anna.gymmembership.controller;

import com.anna.gymmembership.entity.GymMembership;
import com.anna.gymmembership.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gyms/{gymId}/memberships")
public class MembershipController {
    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public ResponseEntity<GymMembership> createMembership(@PathVariable Long gymId, @RequestBody GymMembership gymMembership) {
        GymMembership membership = membershipService.createMembership(gymId, gymMembership);
        return ResponseEntity.ok(membership);
    }

    @GetMapping
    public ResponseEntity<List<GymMembership>> getAllMemberships(@PathVariable Long gymId) {
        return ResponseEntity.ok(membershipService.getMembershipsByGymId(gymId));
    }

    @PatchMapping("/{membershipId}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable Long membershipId){
        membershipService.cancelMembership(membershipId);
        return ResponseEntity.noContent().build();
    }
}
