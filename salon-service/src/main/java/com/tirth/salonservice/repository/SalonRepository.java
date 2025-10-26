package com.tirth.salonservice.repository;

import com.tirth.salonservice.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalonRepository extends JpaRepository<Salon, Long> {

    Salon findByOwnerId(Long id);

    @Query(
           "select s from Salon s where" +
                   "(lower(s.city) like lower(concat('%', :keyword, '%') ) OR " +
                   "lower(s.name) like lower(concat('%', :keyword, '%') ) OR " +
                   "lower(s.address) like lower(concat('%', :keyword, '%') ) ) "
    )
    List<Salon> searchSalonsBy(@Param("keyword") String keyword);
}
