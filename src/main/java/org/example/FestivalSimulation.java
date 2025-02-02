package org.example;

import java.util.ArrayList;
import java.util.List;


public class FestivalSimulation {
    public static void main(String[] args) {
        Festival festival = new Festival();
        FestivalGate gate = festival.getGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        statsThread.start();

        List<Thread> attendees = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(TicketType.getRandomTicket(), gate);
            attendees.add(attendee);
            attendee.start();
        }

        // Ensure all attendees finish
        for (Thread attendee : attendees) {
            try {
                attendee.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
