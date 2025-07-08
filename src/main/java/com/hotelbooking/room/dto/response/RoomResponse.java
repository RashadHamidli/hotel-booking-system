package com.hotelbooking.room.dto.response;

import com.hotelbooking.room.entity.RoomStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomResponse {
    Long id;
    Long hotelId;
    BigDecimal price;
    Long roomNumber;
    RoomStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
