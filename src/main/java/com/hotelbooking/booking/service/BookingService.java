package com.hotelbooking.booking.service;

import com.hotelbooking.booking.dto.request.BookingCreateRequest;
import com.hotelbooking.booking.dto.request.BookingUpdateRequest;
import com.hotelbooking.booking.dto.response.BookingResponse;
import com.hotelbooking.booking.entity.Booking;
import com.hotelbooking.booking.mapper.BookingMapper;
import com.hotelbooking.booking.repository.BookingRepository;
import com.hotelbooking.common.dto.PageMeta;
import com.hotelbooking.common.dto.PageResponse;
import com.hotelbooking.common.exception.NotFoundException;
import com.hotelbooking.room.entity.Room;
import com.hotelbooking.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final RoomService roomService;

    @Transactional(readOnly = true)
    public BookingResponse findBookingById(Long id) {
        Booking booking = findBookingByBookingId(id);
        return bookingMapper.bookingToBookingResponse(booking);
    }

    @Transactional(readOnly = true)
    public PageResponse<BookingResponse> findAllBooking(Pageable pageable) {
        Page<Booking> bookings = bookingRepository.findAll(pageable);
        List<BookingResponse> bookingResponseList = bookingMapper.bookingPageToBookingResonseList(bookings);
        PageMeta pageMeta = new PageMeta(
                bookings.getNumber(),
                bookings.getSize(),
                bookings.getTotalElements(),
                bookings.getTotalPages(),
                bookings.hasNext(),
                bookings.hasPrevious()
        );
        return new PageResponse<>(bookingResponseList, pageMeta);
    }

    @Transactional
    public BookingResponse createBooking(BookingCreateRequest bookingCreateRequest) {
        log.info("Creating booking with request: {}", bookingCreateRequest);
        Room room = roomService.findRoomByIdOrThrow(bookingCreateRequest.getRoomId());
        Booking booking = bookingMapper.createBookingFromBookingCreateRequest(bookingCreateRequest);
        booking.setRoom(room);
        Booking savedBooking = bookingRepository.save(booking);
        log.info("Room created successfully with id: {}", savedBooking.getId());
        return bookingMapper.bookingToBookingResponse(savedBooking);
    }

    @Transactional
    public void deleteBooking(Long id) {
        log.info("Deleting booking with id: {}", id);
        Booking booking = findBookingByBookingId(id);
        bookingRepository.delete(booking);
        log.info("Booking deleted successfully with id: {}", id);
    }

    @Transactional
    public BookingResponse updateBooking(Long id, BookingUpdateRequest bookingUpdateRequest) {
        log.info("Updating booking with ID: {}, request: {}", id, bookingUpdateRequest);
        Booking booking = findBookingByBookingId(id);
        bookingMapper.updateBookingFromBookingRequest(bookingUpdateRequest, booking);
        Booking updateBooking = bookingRepository.save(booking);
        log.info("Room updated successfully with ID: {}", id);
        return bookingMapper.bookingToBookingResponse(updateBooking);
    }

    public Booking findBookingByBookingId(Long id) {
        return bookingRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Booking not found with id: " + id));
    }
}
