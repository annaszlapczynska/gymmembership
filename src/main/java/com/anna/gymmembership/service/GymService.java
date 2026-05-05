package com.anna.gymmembership.service;

import com.anna.gymmembership.dto.ReportDTO;
import com.anna.gymmembership.entity.Gym;
import com.anna.gymmembership.repository.GymRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ReportDTO> generateReport() {
        List<Object[]> results = gymRepo.getReportData();
        return results.stream().map(result -> new ReportDTO(
                (String) result[0],
                (BigDecimal) result[1],
                (String) result[2]
        )).collect(Collectors.toList());

    }
}
