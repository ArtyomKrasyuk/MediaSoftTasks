package org.example;

public class JsonData {
    @JsonField(name = "public_field")
    public String str;
    @JsonField(name = "private_field")
    private double number;

    public JsonData(String str, double number) {
        this.str = str;
        this.number = number;
    }

    public double getNumber() {
        return number;
    }
}
