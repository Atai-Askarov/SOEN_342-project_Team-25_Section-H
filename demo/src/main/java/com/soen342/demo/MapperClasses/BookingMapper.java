package com.soen342.demo.MapperClasses;

import com.soen342.demo.IdentityClasses.BookingIdentity;
import com.soen342.demo.dto.BookingDto;

public class BookingMapper {

    public static BookingDto mapToBookingDto(BookingIdentity booking) {
        return new BookingDto(
            booking.getBookingId(),
            booking.getOfferingId(),
            booking.getClientId(),
            booking.isAvailability()
        );
    }

    public static BookingIdentity mapToBookingIdentity(BookingDto bookingDto) {
        return new BookingIdentity(
            bookingDto.getBookingId(),
            bookingDto.getOfferingId(),
            bookingDto.getClientId(),
            bookingDto.isAvailability()
        );
    }
}
