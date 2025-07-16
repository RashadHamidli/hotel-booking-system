package com.hotelbooking.booking.entity;

import com.hotelbooking.common.entity.BaseEntity;
import com.hotelbooking.room.entity.Room;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
@Getter
@Setter
@ToString
public class Booking extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "customer_name")
    String customerName;
    @Column(name = "customer_email")
    String customerEmail;
    @Column(name = "start_date")
    LocalDateTime startDate;
    @Column(name = "end_date")
    LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    BookingStatus status;
    @ManyToOne
    @JoinColumn(name = "room_id")
    Room room;

}
