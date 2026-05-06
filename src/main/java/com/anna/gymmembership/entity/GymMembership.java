package com.anna.gymmembership.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="gym_memberships")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GymMembership {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0) // price can't be negative
    @Column(nullable = false, precision = 10, scale = 2) // in the case of group membership assuming price per member
    private BigDecimal amount;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MembershipType type;

    @Column(nullable = false)
    private Integer durationMonths;

    @Column(nullable = false)
    private Integer maxMembers;

    @ManyToOne
    @JoinColumn(name = "gym", nullable = false)
    @JsonIgnore
    private Gym gym;
}
