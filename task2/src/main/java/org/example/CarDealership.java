package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    private List<Car> cars;

    public CarDealership() {
        this.cars = new ArrayList<>();
    }

    // Добавить машину
    public boolean append(Car car){
        for(Car elem: cars){
            if(elem.getVIN().equals(car.getVIN())) return false;
        }
        cars.add(car);
        return true;
    }

    // Найти все машины указанного производителя
    public List<Car> findByManufacturer(String manufacturer){
        return cars.stream().filter(car -> car.getManufacturer().equals(manufacturer)).toList();
    }

    // Вывести среднюю цену машин определённого типа
    public double getAveragePrice(Car.Type type){
        return cars.stream().filter(car -> car.getType() == type).mapToDouble(car -> (double) car.getPrice()).average().orElse(0.0);
    }

    // Cписок машин, отсортированных по году выпуска (от новых к старым)
    public List<Car> getSortedList(){
        return cars.stream().sorted().toList();
    }

    // Количество машин каждого типа
    public Map<Car.Type, Long> getNumberOfCars(){
        return cars.stream().collect(Collectors.groupingBy(Car::getType, Collectors.counting()));
    }

    // Самая старая машина
    public Car getTheOldestCar(){
        return cars.stream().min(Comparator.comparing(Car::getYear)).orElse(null);
    }

    // Самая новая машина
    public Car getTheNewestCar(){
        return cars.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }
}
