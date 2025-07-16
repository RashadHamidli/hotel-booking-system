package com.hotelbooking.hotel.service;

import com.hotelbooking.common.exception.NotFoundException;
import com.hotelbooking.hotel.dto.request.HotelCreateRequest;
import com.hotelbooking.common.dto.PageResponse;
import com.hotelbooking.hotel.dto.response.HotelResponse;
import com.hotelbooking.hotel.dto.request.HotelUpdateRequest;
import com.hotelbooking.common.dto.PageMeta;
import com.hotelbooking.hotel.entity.Hotel;
import com.hotelbooking.hotel.mapper.HotelMapper;
import com.hotelbooking.hotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Transactional(readOnly = true)
    public PageResponse<HotelResponse> getAllHotels(Pageable pageable) {
        Page<Hotel> hotels = hotelRepository.findAll(pageable);
        List<HotelResponse> hotelResponses = hotelMapper.hotelPageToHotelResponseList(hotels);
        PageMeta pageMeta = new PageMeta(
                hotels.getNumber(),
                hotels.getSize(),
                hotels.getTotalElements(),
                hotels.getTotalPages(),
                hotels.hasNext(),
                hotels.hasPrevious()
        );
        return new PageResponse<>(hotelResponses, pageMeta);
    }

    @Transactional(readOnly = true)
    public HotelResponse getHotelById(Long id) {
        Hotel hotel = findHotelByIdOrThrow(id);
        return hotelMapper.hotelToHotelResponse(hotel);
    }

    @Transactional
    public HotelResponse createHotel(HotelCreateRequest hotelCreateRequest) {
        log.info("Creating hotel with request: {}", hotelCreateRequest);
        Hotel hotel = hotelMapper.hotelRequestToHotel(hotelCreateRequest);
        Hotel savedHotel = hotelRepository.save(hotel);
        log.info("Hotel created successfully with ID: {}", savedHotel.getId());
        return hotelMapper.hotelToHotelResponse(savedHotel);
    }

    @Transactional
    public void deleteHotel(Long id) {
        log.info("Deleting hotel with ID: {}", id);
        Hotel hotel = findHotelByIdOrThrow(id);
        hotelRepository.delete(hotel);
        log.info("Hotel deleted successfully with ID: {}", id);
    }

    @Transactional
    public HotelResponse hotelUpdate(HotelUpdateRequest request, Long id) {
        log.info("Updating hotel with ID: {}, request: {}", id, request);
        Hotel hotel = findHotelByIdOrThrow(id);
        hotelMapper.updateHotelFromRequest(request, hotel);
        hotelRepository.save(hotel);
        log.info("Hotel updated successfully with ID: {}", id);
        return hotelMapper.hotelToHotelResponse(hotel);
    }

    public Hotel findHotelByIdOrThrow(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hotel not found with id: " + id));
    }
}
