package com.hotelbooking.booking.dto.request;

import com.hotelbooking.booking.entity.BookingStatus;
import com.hotelbooking.booking.validation.ValidDateRange;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ValidDateRange
public class BookingCreateRequest {
    @NotEmpty
    @Length(max = 50, min = 3)
    String customerName;
    @NotEmpty
    @Email
    String customerEmail;
    @NotNull
    @FutureOrPresent
    LocalDate startDate;
    @FutureOrPresent
    @NotNull
    LocalDate endDate;
    @NotNull
    BookingStatus status = BookingStatus.ACTIVE;
    @NotNull
    Long roomId;
}
