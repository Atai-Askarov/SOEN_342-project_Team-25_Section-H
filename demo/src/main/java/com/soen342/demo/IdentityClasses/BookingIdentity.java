package com.soen342.demo.IdentityClasses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class BookingIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "offering_id", nullable = false)
    private int offeringId;

    @Column(name = "client_id", nullable = false)
    private int clientId;

    @Column(name = "is_available", nullable = false)
    private boolean availability;
}
