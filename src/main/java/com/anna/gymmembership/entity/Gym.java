package com.anna.gymmembership.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "gyms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gym {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, unique = true)
    private String name;

    @Column (nullable = false)
    private String address;

    @Column (nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    private List<GymMembership> memberships;


}
