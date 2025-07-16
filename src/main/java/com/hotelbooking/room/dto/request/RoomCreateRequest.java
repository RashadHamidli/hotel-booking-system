package com.hotelbooking.room.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class RoomCreateRequest {
    @NotNull
    Long hotelId;
    @NotNull
    Long roomNumber;
    @NotNull
    @DecimalMin("0.0")
    BigDecimal price;
}
