package org.example;

public class UltraLuxRoom extends LuxRoom{

    public UltraLuxRoom(int number, boolean booked) {
        super(number, Prices.ULTRALUX.getPrice(), booked);
    }
}
