package org.example;

import java.util.Random;
// In this class each attendee thread gets a random ticket and adds it to the queue.
class FestivalAttendeeThread extends Thread {
    private final TicketType ticketType;
    private final FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(500)); // Simulate entry time
            gate.addTicket(ticketType);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
