package com.hotelbooking.booking.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
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
