package com.anna.gymmembership.service;

import com.anna.gymmembership.entity.GymMembership;
import com.anna.gymmembership.entity.Member;
import com.anna.gymmembership.entity.MembershipStatus;
import com.anna.gymmembership.repository.MemberRepo;
import com.anna.gymmembership.repository.MembershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private MembershipRepo membershipRepo;

    public Member createMember(Long membershipId, Member member) {
        GymMembership membership = membershipRepo.findById(membershipId)
                .orElseThrow(() -> new RuntimeException("GymMembership not found"));

        long currentMemebers = memberRepo.countByMembershipIdAndStatus(membershipId, MembershipStatus.ACTIVE);
        if(currentMemebers >= membership.getMaxMembers()){
            throw new RuntimeException("Maximum number of members reached");
        }
        member.setStartDate(LocalDate.now());
        member.setMembership(membership);
        member.setStatus(MembershipStatus.ACTIVE);

        return memberRepo.save(member);
    }
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }
}
