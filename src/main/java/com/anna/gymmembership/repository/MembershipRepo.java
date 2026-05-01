package com.anna.gymmembership.repository;

import com.anna.gymmembership.entity.GymMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepo extends JpaRepository<GymMembership,Long> {
}
