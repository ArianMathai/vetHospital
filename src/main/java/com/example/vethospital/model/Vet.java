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
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vet_seq_gen")
    @SequenceGenerator(name = "cvet_seq_gen", sequenceName = "vet_seq", allocationSize = 1)
    @Column(name="vet_id")
    private Long vetId = 0L;
    @Column(name = "vet_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vet_id")
    private List<Appointment> appointments = new ArrayList<>();
}
