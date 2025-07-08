package com.hotelbooking.room.controller;

import com.hotelbooking.common.dto.PageResponse;
import com.hotelbooking.room.dto.request.RoomCreateRequest;
import com.hotelbooking.room.dto.request.RoomUpdateRequest;
import com.hotelbooking.room.dto.response.RoomResponse;
import com.hotelbooking.room.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/rooms")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<PageResponse<RoomResponse>> getAll(Pageable pageable) {
        PageResponse<RoomResponse> rooms = roomService.getAll(pageable);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable Long id) {
        RoomResponse roomResponse = roomService.getRoomById(id);
        return ResponseEntity.ok(roomResponse);
    }

    @GetMapping("/{id}/hotel")
    public ResponseEntity<PageResponse<RoomResponse>> getRoomsByHotelId(@PathVariable Long id, Pageable pageable) {
        PageResponse<RoomResponse> response = roomService.getAllRoomByHotelId(id,pageable);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RoomResponse> createRoom(@RequestBody
                                                   @Valid RoomCreateRequest roomCreateRequest) {
        return ResponseEntity.ok(roomService.createRoom(roomCreateRequest));

    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> updateRoom(@PathVariable Long id,
                                                   @RequestBody
                                                   @Valid RoomUpdateRequest room) {
        RoomResponse response = roomService.updateRoom(id, room);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomById(@PathVariable Long id) {
        roomService.deleteRoomById(id);
        return ResponseEntity.noContent().build();
    }
}
