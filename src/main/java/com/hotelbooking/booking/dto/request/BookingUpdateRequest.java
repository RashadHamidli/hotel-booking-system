package com.hotelbooking.booking.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingUpdateRequest {
    @NotEmpty
    String customerName;
    @NotEmpty
    @Email
    String customerEmail;
    @NotNull
    LocalDateTime startDate;
    @NotNull
    LocalDateTime endDate;
}
