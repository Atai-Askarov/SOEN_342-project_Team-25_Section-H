package com.soen342.demo.ServiceInterfaces;

import java.util.List;

import com.soen342.demo.dto.BookingDto;

public interface BookingService {
    BookingDto createBooking(BookingDto bookingDto);
    BookingDto getBookingById(int id);
    void createBookingDto(int bookingId, int offeringId, int clientId);
    void cancelBooking(int bookingId);
    List<BookingDto> getBookingsByClientId(int clientId);
}
