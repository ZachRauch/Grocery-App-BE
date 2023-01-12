package net.yorksolutions.zachrauchpantrybe.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pantry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public Long userId;

    @OneToMany
    public List<Items> items;
}
