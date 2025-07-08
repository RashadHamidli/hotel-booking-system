package com.hotelbooking.hotel.controller;

import com.hotelbooking.hotel.dto.request.HotelCreateRequest;
import com.hotelbooking.common.dto.PageResponse;
import com.hotelbooking.hotel.dto.response.HotelResponse;
import com.hotelbooking.hotel.dto.request.HotelUpdateRequest;
import com.hotelbooking.hotel.service.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotels")
@Validated
public class HotelController {
    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<PageResponse<HotelResponse>> getAllHotels(Pageable pageable) {
        PageResponse<HotelResponse> hotels = hotelService.getAllHotels(pageable);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> getHotelById(@PathVariable Long id) {
        HotelResponse hotelResponse = hotelService.getHotelById(id);
        return ResponseEntity.ok(hotelResponse);
    }

    @PostMapping
    public ResponseEntity<HotelResponse> createHotel(@RequestBody
                                                     @Valid HotelCreateRequest hotelCreateRequest) {
        HotelResponse hotelResponse = hotelService.createHotel(hotelCreateRequest);
        return ResponseEntity.ok(hotelResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateHotel(@RequestBody
                                            @Valid HotelUpdateRequest request,
                                            @PathVariable Long id) {
        hotelService.hotelUpdate(request, id);
        return ResponseEntity.noContent().build();
    }
}
