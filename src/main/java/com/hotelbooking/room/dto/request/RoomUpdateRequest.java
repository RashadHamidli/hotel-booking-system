package com.hotelbooking.room.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class RoomUpdateRequest {
    @NotNull
    Long roomNumber;
    @DecimalMin("0.0")
    @Digits(integer = 8, fraction = 2)
    BigDecimal price;
}
