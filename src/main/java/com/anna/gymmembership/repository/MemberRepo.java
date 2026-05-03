package com.anna.gymmembership.repository;

import com.anna.gymmembership.entity.Member;
import com.anna.gymmembership.entity.MembershipStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member,Long> {

    long countByMembershipIdAndStatus(Long membershipId, MembershipStatus status);

    @Modifying
    @Transactional
    @Query(value = "UPDATE members SET status = :status WHERE membership_plan = :membershipId", nativeQuery = true)
    void cancelByMembershipId(@Param("membershipId") Long membershipId, @Param("status") String status);

}
