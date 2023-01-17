package net.yorksolutions.zachrauchpantrybe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String name;

    public String itemImage;

}
