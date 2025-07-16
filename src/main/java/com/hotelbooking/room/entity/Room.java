package com.hotelbooking.room.entity;

import com.hotelbooking.booking.entity.Booking;
import com.hotelbooking.common.entity.BaseEntity;
import com.hotelbooking.hotel.entity.Hotel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
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
public class Room extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "room_number")
    Long roomNumber;
    BigDecimal price;
    @Enumerated(EnumType.STRING)
    RoomStatus status;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    Hotel hotel;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Booking> bookings;
}
