package com.hotelbooking.booking.dto.request;

import com.hotelbooking.booking.entity.BookingStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class BookingCreateRequest {
    String customerName;
    String customerEmail;
    LocalDate startDate;
    LocalDate endDate;
    String status= BookingStatus.ACTIVE.name();
    Long roomId;
}
