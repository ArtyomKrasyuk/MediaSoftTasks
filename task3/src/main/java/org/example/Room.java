package org.example;

import java.util.Random;

public abstract class Room {
    private int number;
    private int maxCapacity;
    private int price;
    private boolean booked;

    public Room(int number, int price, boolean booked) {
        Random random = new Random();
        this.number = number;
        this.maxCapacity = random.nextInt(1, 6);
        this.price = price;
        this.booked = booked;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                '}';
    }
}
