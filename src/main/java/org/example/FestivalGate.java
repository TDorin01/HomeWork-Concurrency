package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// This class is a thread-safe queue to store ticket entries.

public class FestivalGate {
    private final BlockingQueue<TicketType> ticketQueue = new LinkedBlockingQueue<>();

    public void addTicket(TicketType ticket) {
        ticketQueue.add(ticket);
    }

    public List<TicketType> drainTickets() {
        List<TicketType> tickets = new ArrayList<>();
        ticketQueue.drainTo(tickets);
        return tickets;
    }

}
