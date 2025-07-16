package com.hotelbooking.room.mapper;

import com.hotelbooking.hotel.entity.Hotel;
import com.hotelbooking.room.dto.request.RoomCreateRequest;
import com.hotelbooking.room.dto.request.RoomUpdateRequest;
import com.hotelbooking.room.dto.response.RoomResponse;
import com.hotelbooking.room.entity.Room;
import com.hotelbooking.room.entity.RoomStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    @Mapping(source = "hotel.id", target = "hotelId")
    List<RoomResponse> roomPageToRoomResponseList(Page<Room> allRoom);

    @Mapping(source = "hotel.id", target = "hotelId")
    RoomResponse roomToRoomResponse(Room room);

    void updateRoomFromRequest(RoomUpdateRequest request, @MappingTarget Room room);

    @Mapping(target = "status", constant = "AVAILABLE")
    Room createRoomFromRoomCreateRequest(RoomCreateRequest request);


}
