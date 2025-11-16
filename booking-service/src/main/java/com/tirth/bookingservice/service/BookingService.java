package com.tirth.bookingservice.service;

import com.tirth.bookingservice.domain.BookingStatus;
import com.tirth.bookingservice.dto.BookingRequest;
import com.tirth.bookingservice.dto.SalonDTO;
import com.tirth.bookingservice.dto.ServiceDTO;
import com.tirth.bookingservice.dto.UserDTO;
import com.tirth.bookingservice.modal.Booking;
import com.tirth.bookingservice.modal.SalonReport;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {

    Booking createBooking(BookingRequest booking,
                          UserDTO user,
                          SalonDTO salon,
                          Set<ServiceDTO> serviceDTOSet) throws Exception;


    List<Booking> getBookingsByCustomer(Long customerId);
    List<Booking> getBookingsBySalon(Long salonId);
    Booking getBookingById(Long id) throws Exception;
    Booking updateBooking(Long bookingId, BookingStatus status) throws Exception;
    List<Booking> getBookingByDate(LocalDate date,  Long salonId);
    SalonReport getSalonReport(Long salonId);
    void deleteBooking(Long bookingId) throws Exception;
}
