package com.tirth.bookingservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ServiceDTO {

    private Long id;

    private String name;

    private String description;

    private String price;

    private int duration;

    private Long salonId;

    private Long category;

    private List<String> images;
}
