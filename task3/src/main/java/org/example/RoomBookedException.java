package org.example;

public class RoomBookedException extends RuntimeException {
    public RoomBookedException() {
        super();
    }

    public RoomBookedException(String message) {
        super(message);
    }
}
