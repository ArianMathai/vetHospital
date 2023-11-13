package com.example.vethospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq_gen")
    @SequenceGenerator(name = "pet_seq_gen", sequenceName = "pet_seq", allocationSize = 1)
    @Column(name="pet_id")
    private Long petId = 0L;

    @Column(name = "pet_name")
    private String petName;
    @Column(name = "pet_type")
    private String petType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private List<Appointment> appointments = new ArrayList<>();

    public Pet(String petName, String petType) {
        this.petName = petName;
        this.petType = petType;
    }
}
