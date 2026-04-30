package com.anna.gymmembership.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private LocalDate startDate;

    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private MembershipStatus status;
}
