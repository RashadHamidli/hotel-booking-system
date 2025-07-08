package com.hotelbooking.booking.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingUpdateRequest {
    String customerName;
    String customerEmail;
    LocalDateTime startDate;
    LocalDateTime endDate;
}
