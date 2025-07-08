package com.hotelbooking.booking.controller;

import com.hotelbooking.booking.dto.request.BookingCreateRequest;
import com.hotelbooking.booking.dto.request.BookingUpdateRequest;
import com.hotelbooking.booking.dto.response.BookingResponse;
import com.hotelbooking.booking.service.BookingService;
import com.hotelbooking.common.dto.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookings")
@Validated
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> findBookingById(@PathVariable Long id) {
        BookingResponse bookingResponse = bookingService.findBookingById(id);
        return ResponseEntity.ok().body(bookingResponse);
    }

    @GetMapping
    public ResponseEntity<PageResponse<BookingResponse>> findAllBookings(Pageable pageable) {
        PageResponse<BookingResponse> bookingResponse = bookingService.findAllBooking(pageable);
        return ResponseEntity.ok().body(bookingResponse);
    }

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody
                                                         @Valid BookingCreateRequest bookingCreateRequest) {
        BookingResponse bookingResponse = bookingService.createBooking(bookingCreateRequest);
        return ResponseEntity.ok().body(bookingResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingResponse> updateBooking(@PathVariable Long id,
                              @RequestBody
                              @Valid BookingUpdateRequest booking) {
        BookingResponse bookingResponse= bookingService.updateBooking(id,booking);
        return ResponseEntity.ok().body(bookingResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
