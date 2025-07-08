package com.hotelbooking.booking.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingUpdateRequest {
    @NotEmpty
    @Length(min = 2, max = 50)
    String customerName;
    @Email
    String customerEmail;
    @NotNull
    LocalDateTime startDate;
    @NotNull
    LocalDateTime endDate;
}
