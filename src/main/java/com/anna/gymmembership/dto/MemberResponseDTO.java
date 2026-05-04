package com.anna.gymmembership.dto;

import com.anna.gymmembership.entity.Member;
import lombok.Data;

@Data
public class MemberResponseDTO {
    private Long id;
    private String name;
    private String status;
    private String planName;
    private String gymName;

    public MemberResponseDTO(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.status = member.getStatus().name();
        this.planName = member.getMembership().getName();
        this.gymName = member.getMembership().getGym().getName();
    }
}
