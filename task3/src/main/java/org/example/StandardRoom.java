package org.example;

public class StandardRoom extends ProRoom{

    public StandardRoom(int number, boolean booked) {
        super(number, Prices.STANDARD.getPrice(), booked);
    }
}
