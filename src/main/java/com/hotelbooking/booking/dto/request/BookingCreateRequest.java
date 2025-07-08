package com.hotelbooking.booking.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BookingCreateRequest {
    String customerName;
    String customerEmail;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String status;
    Long roomId;
}
