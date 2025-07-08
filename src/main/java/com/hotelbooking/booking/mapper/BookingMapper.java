package com.hotelbooking.booking.mapper;

import com.hotelbooking.booking.dto.request.BookingCreateRequest;
import com.hotelbooking.booking.dto.response.BookingResponse;
import com.hotelbooking.booking.entity.Booking;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingResponse bookingToBookingResponse(Booking booking);

    List<BookingResponse> bookingPageToBookingResonseList(Page<Booking> bookings);

    Booking bookingCreateRequestToBooking(BookingCreateRequest bookingCreateRequest);
}
