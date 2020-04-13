package com.dataart.flights.controller

import com.dataart.flights.model.Ticket
import com.dataart.flights.repository.TicketRepository
import com.dataart.flights.service.TicketService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.*

@ExtendWith(MockKExtension::class)
internal class TicketControllerTest {

    @InjectMockKs
    private lateinit var subject: TicketController

    @MockK
    private lateinit var ticketService: TicketService

    @Test
    fun `create ticket test`() {
        val ticket = mockk<Ticket>()
        every { ticketService.create(ticket) } returns ticket

        assertEquals(ticket, subject.create(ticket))
    }

    @Test
    fun `findById success`() {
        val existingId = 1234L
        val ticket = mockk<Ticket>()
        every { ticketService.findById(existingId) } returns Optional.of(ticket)

        val actual = subject.findById(existingId)

        assertEquals(HttpStatus.OK, actual.statusCode)
        assertEquals(ticket, actual.body)
    }

    @Test
    fun `findById not found`() {
        val notExistingId = 1234L
        every { ticketService.findById(notExistingId) } returns Optional.empty()

        val actual = subject.findById(notExistingId)

        assertEquals(HttpStatus.NOT_FOUND, actual.statusCode)
        assertNull(actual.body)
    }
}