package org.example;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
// This class wakes up every 5 seconds, processes queued tickets, and prints statistics.
class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                List<TicketType> tickets = gate.drainTickets();
                if (!tickets.isEmpty()) {
                    generateStatistics(tickets);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void generateStatistics(List<TicketType> tickets) {
        Map<TicketType, Long> stats = new EnumMap<>(TicketType.class);
        for (TicketType type : TicketType.values()) {
            stats.put(type, 0L);
        }
        for (TicketType ticket : tickets) {
            stats.put(ticket, stats.get(ticket) + 1);
        }
        System.out.println("\n--- Festival Statistics ---");
        System.out.println("Total Attendees: " + tickets.size());
        for (TicketType type : TicketType.values()) {
            System.out.println(type + ": " + stats.get(type));
        }
    }
}
