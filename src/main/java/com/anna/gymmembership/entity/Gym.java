package com.anna.gymmembership.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    @JsonIgnore
    private List<GymMembership> memberships;


}
