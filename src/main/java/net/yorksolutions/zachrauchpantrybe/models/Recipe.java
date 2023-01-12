package net.yorksolutions.zachrauchpantrybe.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String recipeImage;

    public Long userId;

    public String name;

    @OneToMany
    public List<Items> items;
}
