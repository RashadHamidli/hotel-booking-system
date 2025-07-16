package com.hotelbooking.booking.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookingResponse {
    Long id;
    String customerName;
    String customerEmail;
    LocalDate startDate;
    LocalDate endDate;
    String status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Long roomId;
}
