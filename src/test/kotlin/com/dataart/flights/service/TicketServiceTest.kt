package com.dataart.flights.service

import com.dataart.flights.model.Ticket
import com.dataart.flights.repository.TicketRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
internal class TicketServiceTest {

    @InjectMockKs
    private lateinit var subject: TicketService

    @MockK
    private lateinit var ticketRepository: TicketRepository

    @Test
    fun `create success`() {
        val ticket = mockk<Ticket>()
        every { ticketRepository.save(ticket) } returns ticket

        assertEquals(ticket, subject.create(ticket))

        verify(exactly = 1) {
            ticketRepository.save(ticket)
        }
    }

    @Test
    fun `findById success`() {
        val ticket = mockk<Ticket>()
        every { ticketRepository.findById(any()) } returns Optional.of(ticket)

        assertEquals(Optional.of(ticket), subject.findById(1234))

        verify(exactly = 1) {
            ticketRepository.findById(any())
        }
    }
}