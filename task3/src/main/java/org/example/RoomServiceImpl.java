package org.example;

public class RoomServiceImpl<T extends Room> implements RoomService<T>{
    @Override
    public void clean(T room) {
        System.out.println("Комната " + room + " очищена");
    }

    @Override
    public void reserve(T room) throws RoomBookedException {
        if(room.isBooked()) throw new RoomBookedException("Ошибка: комната " + room + " уже забронирована");
        room.setBooked(true);
        System.out.println("Комната " + room + " забронирована");
    }

    @Override
    public void free(T room) {
        room.setBooked(false);
        System.out.println("Комната " + room + " освобождена");
    }
}
