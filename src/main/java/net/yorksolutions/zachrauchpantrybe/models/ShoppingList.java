package net.yorksolutions.zachrauchpantrybe.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public Long userId;

    @ManyToMany
    public List<Items> items;
}
