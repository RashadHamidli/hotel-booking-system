package com.hotelbooking.booking.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hotelbooking.booking.entity.BookingStatus;
import com.hotelbooking.booking.validation.ValidDateRange;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ValidDateRange
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookingCreateRequest {
    @NotBlank
    @Length(max = 50, min = 2)
    String customerName;
    @Email
    String customerEmail;
    @NotNull
    @FutureOrPresent
    LocalDate startDate;
    @NotNull
    @FutureOrPresent
    LocalDate endDate;
    @NotNull
    Long roomId;
}
