package com.tirth.serviceoffering.service;

import com.tirth.serviceoffering.dto.CategoryDTO;
import com.tirth.serviceoffering.dto.SalonDTO;
import com.tirth.serviceoffering.dto.ServiceDTO;
import com.tirth.serviceoffering.modal.ServiceOffering;

import java.security.Provider;
import java.util.Set;

public interface ServiceOfferingService {

    ServiceOffering createService(SalonDTO salonDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO);

    ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception;

    Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId);

    Set<ServiceOffering> getServiceByIds(Set<Long> salonId);

    ServiceOffering getServiceById(Long id) throws Exception;
}
