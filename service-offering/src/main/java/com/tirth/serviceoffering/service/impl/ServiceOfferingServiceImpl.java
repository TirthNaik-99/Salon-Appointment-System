package com.tirth.serviceoffering.service.impl;

import com.tirth.serviceoffering.dto.CategoryDTO;
import com.tirth.serviceoffering.dto.SalonDTO;
import com.tirth.serviceoffering.dto.ServiceDTO;
import com.tirth.serviceoffering.modal.ServiceOffering;
import com.tirth.serviceoffering.repository.ServiceOfferingRepository;
import com.tirth.serviceoffering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService {


    //we can use Autowired for injecting
    private final ServiceOfferingRepository serviceOfferingRepository;

    @Override
    public ServiceOffering createService(SalonDTO salonDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {
        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setImages(serviceDTO.getImages());
        serviceOffering.setSalonId(salonDTO.getId());
        serviceOffering.setName(serviceDTO.getName());
        serviceOffering.setCategoryId(categoryDTO.getId());
        serviceOffering.setDescription(serviceDTO.getDescription());
        serviceOffering.setPrice(serviceDTO.getPrice());
        serviceOffering.setDuration(serviceDTO.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception{

        ServiceOffering serviceOffering = serviceOfferingRepository.findById(serviceId).orElse(null);
        if (serviceOffering != null) {
            throw new Exception("service not exist with id "+ serviceId);
        }

        serviceOffering.setImages(service.getImages());
        serviceOffering.setName(service.getName());
        serviceOffering.setDescription(service.getDescription());
        serviceOffering.setPrice(service.getPrice());
        serviceOffering.setDuration(service.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId) {
        Set<ServiceOffering> services = serviceOfferingRepository.findBySalonId(salonId);
        if(categoryId != null) {
            services = services.stream().filter((service) ->
                    service.getCategoryId() != null && service.getCategoryId() == categoryId).collect(Collectors.toSet());
        }

        return services;
    }

    @Override
    public Set<ServiceOffering> getServiceByIds(Set<Long> ids) {
        List<ServiceOffering> services = serviceOfferingRepository.findAllById(ids);
        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceById(Long id) throws Exception{
        ServiceOffering serviceOffering = serviceOfferingRepository.findById(id).orElse(null);
        if (serviceOffering == null) {
            throw new Exception("service not exist with id "+ id);
        }
        return serviceOffering;
    }
}
