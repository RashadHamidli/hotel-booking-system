package com.hotelbooking.hotel.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelCreateRequest {
    @NotBlank
    @Length(max = 50, min = 3)
    String name;
    @NotBlank
    @Length(max = 50, min = 3)
    String location;
}
