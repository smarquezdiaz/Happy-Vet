package com.vet.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pet")
@NoArgsConstructor
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String species; // TODO change to ENUM

    @Column(nullable = false, length = 80)
    private String breed;

    @Column(nullable = false, length = 20)
    private String sex; // TODO change to ENUM

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(length = 50)
    private String color;

    @Column(length = 500)
    private String observations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", insertable = false, updatable = false)
    private OwnerEntity owner;
}
