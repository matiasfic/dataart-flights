package com.dataart.flights.model

import java.math.BigDecimal
import java.time.OffsetDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Ticket(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,
        val departureDate: OffsetDateTime,
        val arrivalDate: OffsetDateTime,
        val cityOfOrigin: String,
        val destinationCity: String,
        val passengerName: String,
        val passengerAge: Int = 0,
        val luggageStorage: Boolean = false,
        val price: BigDecimal
)