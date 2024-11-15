package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.dto.BookingDto;

public interface BookingService {
    BookingDto createBooking(BookingDto bookingDto);
    BookingDto getBookingById(int id);
}
