package com.example.vethospital.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_seq", allocationSize = 1)
    @Column(name="customer_id")
    private Long customerId = 0L;
    @Column(name = "customer_email")
    private String customerEmail;
    @Column(name = "customer_name")
    private String CustomerName;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customer")
    @JoinColumn(name = "customer_id")
    private List<Pet> pets = new ArrayList<>();

    public Customer(String customerEmail, String customerName) {
        this.customerEmail = customerEmail;
        CustomerName = customerName;
    }
}
