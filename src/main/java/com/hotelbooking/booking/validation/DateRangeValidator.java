package com.hotelbooking.booking.validation;

import com.hotelbooking.booking.dto.request.BookingCreateRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, BookingCreateRequest> {

    @Override
    public boolean isValid(BookingCreateRequest request, ConstraintValidatorContext context) {
        if (request.getStartDate() == null || request.getEndDate() == null) {
            return true;
        }
        return !request.getEndDate().isBefore(request.getStartDate());
    }
}

