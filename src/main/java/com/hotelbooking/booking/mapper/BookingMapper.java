package com.hotelbooking.booking.mapper;

import com.hotelbooking.booking.dto.request.BookingCreateRequest;
import com.hotelbooking.booking.dto.request.BookingUpdateRequest;
import com.hotelbooking.booking.dto.response.BookingResponse;
import com.hotelbooking.booking.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookingMapper {

    @Mapping(source = "room.id", target = "roomId")
    BookingResponse bookingToBookingResponse(Booking booking);

    @Mapping(source = "room.id", target = "roomId")
    List<BookingResponse> bookingPageToBookingResonseList(Page<Booking> bookings);

    Booking bookingCreateRequestToBooking(BookingCreateRequest bookingCreateRequest);

    void updateBookingFromBookingRequest(BookingUpdateRequest bookingUpdateRequest, @MappingTarget Booking booking);
}
