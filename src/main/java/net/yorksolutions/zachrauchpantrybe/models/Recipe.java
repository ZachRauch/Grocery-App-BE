package net.yorksolutions.zachrauchpantrybe.models;

import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.sql.Clob;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String recipeImage;

    public Long userId;

    public String name;

    @ManyToMany
    public List<Items> items;

    @Column(length = 10000)
    public String steps;
}
