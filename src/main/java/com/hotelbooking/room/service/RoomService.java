package com.hotelbooking.room.service;

import com.hotelbooking.common.dto.PageMeta;
import com.hotelbooking.common.dto.PageResponse;
import com.hotelbooking.common.exception.NotFoundException;
import com.hotelbooking.hotel.entity.Hotel;
import com.hotelbooking.hotel.service.HotelService;
import com.hotelbooking.room.dto.request.RoomCreateRequest;
import com.hotelbooking.room.dto.request.RoomUpdateRequest;
import com.hotelbooking.room.dto.response.RoomResponse;
import com.hotelbooking.room.entity.Room;
import com.hotelbooking.room.mapper.RoomMapper;
import com.hotelbooking.room.repository.RoomRepository;
import jakarta.validation.Valid;
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
public class RoomService {
    private final RoomRepository roomRepository;
    private final HotelService hotelService;
    private final RoomMapper roomMapper;

    @Transactional(readOnly = true)
    public PageResponse<RoomResponse> getAll(Pageable pageable) {
        Page<Room> rooms = roomRepository.findAll(pageable);
        List<RoomResponse> roomResponses = roomMapper.roomPageToRoomResponseList(rooms);
        PageMeta pageMeta = new PageMeta(
                rooms.getNumber(),
                rooms.getSize(),
                rooms.getTotalElements(),
                rooms.getTotalPages(),
                rooms.hasNext(),
                rooms.hasPrevious());

        return new PageResponse<>(roomResponses, pageMeta);
    }

    @Transactional(readOnly = true)
    public RoomResponse getRoomById(Long id) {
        Room room = findRoomByIdOrThrow(id);
        return roomMapper.roomToRoomResponse(room);
    }


    @Transactional
    public RoomResponse createRoom(RoomCreateRequest roomCreateRequest) {
        log.info("Creating room with request: {}", roomCreateRequest);
        Hotel hotel = hotelService.findHotelByIdOrThrow(roomCreateRequest.getHotelId());
        Room room = roomMapper.createRoomFromRoomCreateRequest(roomCreateRequest);
        room.setHotel(hotel);
        Room savedRoom = roomRepository.save(room);
        log.info("Room created successfully with id: {}", savedRoom.getId());
        return roomMapper.roomToRoomResponse(savedRoom);
    }

    @Transactional
    public void deleteRoomById(Long id) {
        log.info("Deleting room with ID: {}", id);
        Room room = findRoomByIdOrThrow(id);
        roomRepository.delete(room);
        log.info("Room deleted successfully with ID: {}", id);
    }

    @Transactional
    public RoomResponse updateRoom(Long id, @Valid RoomUpdateRequest roomRequest) {
        log.info("Updating room with ID: {}, request: {}", id, roomRequest);
        Room room = findRoomByIdOrThrow(id);
        roomMapper.updateRoomFromRequest(roomRequest, room);
        roomRepository.save(room);
        log.info("Room updated successfully with ID: {}", id);
        return roomMapper.roomToRoomResponse(room);
    }

    @Transactional(readOnly = true)
    public PageResponse<RoomResponse> getAllRoomByHotelId(Long hotelId, Pageable pageable) {
        Page<Room> rooms = roomRepository.findAllRoomByHotelId(hotelId, pageable);
        List<RoomResponse> roomResponses = roomMapper.roomPageToRoomResponseList(rooms);
        PageMeta pageMeta = new PageMeta(
                rooms.getNumber(),
                rooms.getSize(),
                rooms.getTotalElements(),
                rooms.getTotalPages(),
                rooms.hasNext(),
                rooms.hasPrevious());
        return new PageResponse<>(roomResponses, pageMeta);
    }

    public Room findRoomByIdOrThrow(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Room not found with id: " + id));
    }
}
