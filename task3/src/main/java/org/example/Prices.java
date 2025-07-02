package org.example;

public enum Prices {
    ECONOMY(1000),
    STANDARD(1500),
    LUX(5000),
    ULTRALUX(10000);

    private int price;

    Prices(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
