package com.vet.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "consultation")
@NoArgsConstructor
public class ConsultationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pet_id", nullable = false)
    private Long petId;

    @Column(name = "consultation_date")
    private LocalDateTime consultationDate;

    @Column(length = 500)
    private String diagnosis;

    @Column(length = 500)
    private String treatment;

    @Column(length = 500)
    private String observations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id", insertable = false, updatable = false)
    private PetEntity pet;
}
