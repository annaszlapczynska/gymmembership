package com.anna.gymmembership.controller;

import com.anna.gymmembership.dto.ReportDTO;
import com.anna.gymmembership.entity.Gym;
import com.anna.gymmembership.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gyms")
public class GymController {
    @Autowired
    private GymService gymService;

    @PostMapping
    public ResponseEntity<Gym> createGym(@RequestBody Gym gym) {
        Gym createGym = gymService.createGym(gym);
        return ResponseEntity.ok(createGym);
    }

    @GetMapping
    public ResponseEntity<List<Gym>> getAllGyms() {
        return ResponseEntity.ok(gymService.getAllGyms());
    }

    @GetMapping("/report")
    public ResponseEntity<List<ReportDTO>> getReport() {
        return ResponseEntity.ok(gymService.generateReport());
    }
}
