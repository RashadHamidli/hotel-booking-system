package com.hotelbooking.room.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class RoomUpdateRequest {
    Long roomNumber;
    BigDecimal price;
}
