package com.tirth.categoryservice.modal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "images", length = 2000)
    private String image;

    @Column(nullable = false)
    private Long salonId;
}
