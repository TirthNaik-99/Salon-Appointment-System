package com.tirth.serviceoffering.controller;

import com.tirth.serviceoffering.dto.CategoryDTO;
import com.tirth.serviceoffering.dto.SalonDTO;
import com.tirth.serviceoffering.dto.ServiceDTO;
import com.tirth.serviceoffering.modal.ServiceOffering;
import com.tirth.serviceoffering.service.ServiceOfferingService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
            @RequestBody ServiceDTO serviceDTO) {
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategory());
        ServiceOffering serviceOfferings = serviceOfferingService
                .createService(salonDTO, serviceDTO, categoryDTO);
        return ResponseEntity.ok(serviceOfferings);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long id,
            @RequestBody ServiceOffering serviceOffering) throws Exception{

        ServiceOffering serviceOfferings = serviceOfferingService
                .updateService(id, serviceOffering);
        return ResponseEntity.ok(serviceOfferings);
    }
}
