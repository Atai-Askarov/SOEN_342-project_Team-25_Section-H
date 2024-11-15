package com.soen342.demo.ServiceInterfaces;

import org.springframework.stereotype.Service;
import com.soen342.demo.IdentityClasses.BookingIdentity;
import com.soen342.demo.MapperClasses.BookingMapper;
import com.soen342.demo.RepositoryClasses.BookingRepository;
import com.soen342.demo.dto.BookingDto;
import com.soen342.demo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        BookingIdentity booking = BookingMapper.mapToBookingIdentity(bookingDto);
        BookingIdentity savedBooking = bookingRepository.save(booking);
        return BookingMapper.mapToBookingDto(savedBooking);
    }

    @Override
    public BookingDto getBookingById(int id) {
        BookingIdentity booking = bookingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + id));
        return BookingMapper.mapToBookingDto(booking);
    }

    public void createBookingDto(int bookingId, int offeringId, int clientId) {
        BookingDto booking = new BookingDto();
        booking.setBookingId(bookingId);
        booking.setOfferingId(offeringId);
        booking.setClientId(clientId);
        booking.setAvailability(true);
        createBooking(booking);
    }

    public void cancelBooking(int bookingId) {
        bookingRepository.findById(bookingId)
            .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));
        bookingRepository.deleteById(bookingId);
    }
}
