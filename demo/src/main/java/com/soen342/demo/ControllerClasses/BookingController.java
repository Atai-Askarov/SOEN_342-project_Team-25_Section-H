package com.soen342.demo.ControllerClasses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.soen342.demo.dto.BookingDto;
import com.soen342.demo.ServiceInterfaces.BookingService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        BookingDto savedBooking = bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable("id") int bookingId) {
        BookingDto bookingDto = bookingService.getBookingById(bookingId);
        return new ResponseEntity<>(bookingDto, HttpStatus.OK);
    }
}
