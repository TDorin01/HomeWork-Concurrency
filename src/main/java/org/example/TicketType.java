package org.example;

import java.util.Random;
// Enum to generate a random ticket type.
public enum TicketType {
    FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP;

    private static final Random RANDOM = new Random();

    public static TicketType getRandomTicket() {
        return values()[RANDOM.nextInt(values().length)];
    }
}
