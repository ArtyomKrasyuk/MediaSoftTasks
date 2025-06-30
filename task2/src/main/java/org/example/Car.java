package org.example;

import java.util.Objects;

public class Car implements Comparable<Car> {
    public enum Type{
        SEDAN,
        SUV,
        ELECTRIC
    }

    private String VIN;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private int price;
    private Type type;

    public Car(String VIN, String model, String manufacturer, int year, int mileage, int price, Type type) {
        this.VIN = VIN;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.type = type;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(VIN, car.VIN);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(VIN);
    }

    @Override
    public String toString() {
        return String.format("Car: VIN=%s model=%s manufacturer=%s year=%d mileage=%d price=%d", VIN, model, manufacturer, year, mileage, price);
    }

    @Override
    public int compareTo(Car car) {
        return -(this.year - car.getYear());
    }
}
