package com.hotelbooking.booking.dto.request;

import com.hotelbooking.booking.entity.BookingStatus;
import com.hotelbooking.booking.validation.ValidDateRange;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ValidDateRange
public class BookingCreateRequest {
    @NotBlank
    @Length(max = 50, min = 2)
    String customerName;
    @NotNull
    @Email
    String customerEmail;
    @NotNull
    @FutureOrPresent
    LocalDate startDate;
    @NotNull
    @FutureOrPresent
    LocalDate endDate;
    @NotNull
    BookingStatus status = BookingStatus.ACTIVE;
    @NotNull
    Long roomId;
}
