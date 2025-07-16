package com.hotelbooking.common.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ErrorResponse {
    String status;
    String message;
}