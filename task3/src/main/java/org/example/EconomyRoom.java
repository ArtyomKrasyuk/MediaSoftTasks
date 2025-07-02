package org.example;

public class EconomyRoom extends Room{

    public EconomyRoom(int number, boolean booked) {
        super(number, Prices.ECONOMY.getPrice(), booked);
    }
}
