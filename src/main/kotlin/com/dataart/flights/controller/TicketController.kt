package com.dataart.flights.controller

import com.dataart.flights.model.Ticket
import com.dataart.flights.service.TicketService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("tickets")
class TicketController(private val ticketService: TicketService) {

    @PostMapping
    fun create(@RequestBody ticket: Ticket) = ticketService.create(ticket)

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: Long) = ResponseEntity.of(ticketService.findById(id))
}
