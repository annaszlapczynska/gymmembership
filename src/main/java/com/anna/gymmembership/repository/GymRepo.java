package com.anna.gymmembership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anna.gymmembership.entity.Gym;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepo extends JpaRepository<Gym,Long> {
}
