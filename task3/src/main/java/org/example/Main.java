package org.example;


public class Main {
    public static void main(String[] args) {
        EconomyRoom economyRoom = new EconomyRoom(1,  false);
        StandardRoom standardRoom = new StandardRoom(2, false);
        LuxRoom luxRoom = new LuxRoom(3, Prices.LUX.getPrice(), false);
        UltraLuxRoom ultraLuxRoom = new UltraLuxRoom(4, false);

        // Проверка работы RoomServiceImpl
        var roomService = new RoomServiceImpl<>();
        System.out.println("Проверка работы RoomServiceImpl");
        // EconomyRoom
        System.out.println("EconomyRoom");
        roomService.clean(economyRoom);
        roomService.reserve(economyRoom);
        try{
            roomService.reserve(economyRoom);
        } catch (RoomBookedException ex){
            System.out.println(ex.getMessage());
        }
        roomService.free(economyRoom);

        // StandardRoom
        System.out.println("StandardRoom");
        roomService.clean(standardRoom);
        roomService.reserve(standardRoom);
        try{
            roomService.reserve(standardRoom);
        } catch (RoomBookedException ex){
            System.out.println(ex.getMessage());
        }
        roomService.free(standardRoom);

        // LuxRoom
        System.out.println("LuxRoom");
        roomService.clean(luxRoom);
        roomService.reserve(luxRoom);
        try{
            roomService.reserve(luxRoom);
        } catch (RoomBookedException ex){
            System.out.println(ex.getMessage());
        }
        roomService.free(luxRoom);

        // UltraLuxRoom
        System.out.println("UltraLuxRoom");
        roomService.clean(ultraLuxRoom);
        roomService.reserve(ultraLuxRoom);
        try{
            roomService.reserve(ultraLuxRoom);
        } catch (RoomBookedException ex){
            System.out.println(ex.getMessage());
        }
        roomService.free(ultraLuxRoom);

        // Проверка работы LuxRoomServiceImpl
        var luxRoomService = new LuxRoomServiceImpl<>();
        System.out.println("Проверка работы LuxRoomServiceImpl");
        luxRoomService.foodDelivery(luxRoom);
        luxRoomService.foodDelivery(ultraLuxRoom);
        // luxRoomService.foodDelivery(economyRoom); -- не работает, так как можно заказывать еду только в люксовые комнаты
    }
}