package com.tirth.salonservice.service;

import com.tirth.salonservice.model.Salon;
import com.tirth.salonservice.payload.dto.SalonDTO;
import com.tirth.salonservice.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {
    Salon createSalon(SalonDTO salonDTO, UserDTO user);

    Salon updateSalon(SalonDTO salonDTO, UserDTO user, Long salonId) throws Exception;

    List<Salon> getAllSalons();

    Salon getSalonById(Long salonId) throws Exception;

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> searchSalonByCity(String city);
}
