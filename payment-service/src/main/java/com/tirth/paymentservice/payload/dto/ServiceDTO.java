package com.tirth.paymentservice.payload.dto;

import lombok.Data;

import java.util.List;

@Data
public class ServiceDTO {

    private Long id;

    private String name;

    private String description;

    private int price;

    private int duration;

    private Long salonId;

    private Long category;

    private List<String> images;
}
