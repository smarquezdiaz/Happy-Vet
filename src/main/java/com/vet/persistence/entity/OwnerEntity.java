package com.vet.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "owner")
@NoArgsConstructor
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 150)
    private String email;

    @Column(nullable = false, length = 30)
    private String phone;

    @Column(name = "ref_phone", length = 30)
    private String refPhone;

    @OneToMany(mappedBy = "owner")
    private List<PetEntity> pets;
}
