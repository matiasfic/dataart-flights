package com.dataart.flights.repository

import com.dataart.flights.model.Ticket
import org.springframework.data.repository.CrudRepository

interface TicketRepository : CrudRepository<Ticket, Long>