package com.hotelbooking.room.entity;

import com.hotelbooking.booking.entity.Booking;
import com.hotelbooking.common.entity.BaseEntity;
import com.hotelbooking.hotel.entity.Hotel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
@Getter
@Setter
@ToString
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    Long roomNumber;
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal price;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    RoomStatus status=RoomStatus.AVAILABLE;
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    Hotel hotel;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Booking> bookings;
}
