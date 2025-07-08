package com.hotelbooking.hotel.mapper;

import com.hotelbooking.hotel.dto.request.HotelCreateRequest;
import com.hotelbooking.hotel.dto.response.HotelResponse;
import com.hotelbooking.hotel.dto.request.HotelUpdateRequest;
import com.hotelbooking.hotel.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HotelMapper {
    Hotel hotelRequestToHotel(HotelCreateRequest hotelCreateRequest);
    List<HotelResponse> hotelPageToHotelResponseList(Page<Hotel> hotel);
    HotelResponse hotelToHotelResponse(Hotel hotel);
    void updateHotelFromRequest(HotelUpdateRequest request, @MappingTarget Hotel hotel);
}
