package com.anna.gymmembership.controller;

import com.anna.gymmembership.dto.MemberResponseDTO;
import com.anna.gymmembership.entity.Member;
import com.anna.gymmembership.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/plan/{membershipId}")
    public ResponseEntity<Member> register(@PathVariable Long membershipId, @RequestBody Member member) {
        return ResponseEntity.ok(memberService.createMember(membershipId, member));
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDTO>> listAll() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }
}
