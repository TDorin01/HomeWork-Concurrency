package org.example;
// This class encapsulate the FestivalGate, ensuring that every festival has a dedicated
// gate where attendees validate their tickets.
public class Festival {
    private final FestivalGate gate;

    public Festival() {
        this.gate = new FestivalGate();
    }

    public FestivalGate getGate() {
        return gate;
    }
}
