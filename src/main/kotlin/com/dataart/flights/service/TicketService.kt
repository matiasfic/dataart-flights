package com.dataart.flights.service

import com.dataart.flights.model.Ticket
import com.dataart.flights.repository.TicketRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class TicketService(private val ticketRepository: TicketRepository) {

    fun create(ticket: Ticket) = ticketRepository.save(ticket)

    fun findById(id: Long) = ticketRepository.findById(id)

}