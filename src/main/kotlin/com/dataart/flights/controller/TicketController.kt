package com.dataart.flights.controller

import com.dataart.flights.model.Ticket
import com.dataart.flights.service.TicketService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("tickets")
class TicketController(private val ticketService: TicketService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody ticket: Ticket) = ticketService.create(ticket)

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: Long) = ResponseEntity.of(ticketService.findById(id))

    @GetMapping
    fun findAll() = ticketService.findAll()

    @PutMapping("{id}")
    fun update(@PathVariable("id") id: Long,
               @RequestBody ticket: Ticket) = ticketService.update(id, ticket)

    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") id: Long) = ticketService.delete(id)
}
