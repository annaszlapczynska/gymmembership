package com.anna.gymmembership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anna.gymmembership.entity.Gym;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepo extends JpaRepository<Gym,Long> {

    @Query( value = "SELECT g.name as gymName, SUM(gm.amount) AS amount, gm.currency AS currency " +
            "FROM members m " +
            "JOIN gym_memberships gm on m.membership_plan = gm.id " +
            "JOIN gyms g ON g.id = gm.gym " +
            "WHERE m.status = 'ACTIVE' " +
            "GROUP BY g.name, gm.currency ", nativeQuery = true)
    List<Object[]> getReportData();
}
