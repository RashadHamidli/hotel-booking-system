package com.hotelbooking.room.dto.request;

import com.hotelbooking.room.entity.RoomStatus;
import jakarta.validation.constraints.*;
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
    @Min(1)
    @Max(999)
    Long roomNumber;
    @NotNull
    @DecimalMin("0.0")
    @Digits(integer = 8, fraction = 2)
    BigDecimal price;
    @NotNull
    RoomStatus status=RoomStatus.AVAILABLE;
}
