package org.example;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // 1 пункт
        System.out.println("ПУНКТ 1");
        int[] cars = new int[50];
        Random random = new Random();
        // Заполнение массива
        for(int i = 0; i < cars.length; i++) cars[i] = random.nextInt(2000, 2026);
        double sum = 0;
        System.out.println("Машины после 2015 года:");
        for(int car: cars){
            sum += 2025 - car;
            // Вывод машин после 2015 года
            if(car > 2015) System.out.println(car);
        }
        // Вывод среднего возраста
        System.out.printf("Среднее значение возраста: %f\n", sum/cars.length);

        // 2 пункт
        System.out.println("ПУНКТ 2");
        var models = new ArrayList<String>();
        models.add("Toyota Camry");
        models.add("BMW X5");
        models.add("Tesla Model Y");
        models.add("Tesla Model X");
        models.add("BMW X5");

        // Удаление дубликатов
        var set = new HashSet<String>(models);
        models.clear();
        models.addAll(set);
        // Сортировка в обратном порядке
        models.sort(Collections.reverseOrder());
        System.out.println("Сортировка в обратном порядке:");
        System.out.println(models);
        // Сохранение в Set
        set.clear();
        set.addAll(models);
        // Замена Tesla на ELECTRO_CAR
        for(int i = 0; i < models.size(); i++){
            if(models.get(i).contains("Tesla")) models.set(i, models.get(i).replace("Tesla", "ELECTRO_CAR"));
        }
        System.out.println("Замена Tesla на ELECTRO_CAR:");
        System.out.println(models);

        // 3 пункт
        // У car1 и car2 одинаковый VIN
        System.out.println("ПУНКТ 3");
        Car car1 = new Car("abcdef", "Toyota Camry", "Toyota", 2015, 70000, 1400000, Car.Type.SEDAN);
        Car car2 = new Car("hijklm", "Tesla Model X", "Tesla", 2020, 10000, 2500000, Car.Type.ELECTRIC);
        Car car3 = new Car("abcdef", "Toyota Camry", "Toyota", 2016, 20000, 1500000, Car.Type.SEDAN);
        Car car4 = new Car("sdebff", "Tesla Model Y", "Tesla", 2021, 65000, 2000000, Car.Type.ELECTRIC);

        var carSet = new HashSet<Car>();
        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3);
        // Проверка, что дубликаты по VIN не добаляются
        System.out.println("Проверка, что дубликаты по VIN не добаляются:");
        for(Car elem: carSet) System.out.println(elem);

        // * Проверка сортировки по году выпуска (от новых к старым)
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        Collections.sort(carList);
        System.out.println("Отсортированный по году выпуска список машин:");
        System.out.println(carList);

        // 4 пункт
        // Фильтр машин только с пробегом меньше 50000
        System.out.println("ПУНКТ 4");
        System.out.println("Фильтр машин только с пробегом меньше 50000:");
        carList.stream().filter(car -> car.getMileage() < 50000).forEach(System.out::println);
        // Сортировка машин по цене (по убыванию)
        System.out.println("Сортировка машин по цене (по убыванию):");
        carList.stream().sorted(Comparator.comparing(Car::getPrice).reversed()).forEach(System.out::println);
        // Топ 3 самых дорогих машин
        System.out.println("Топ 3 самых дорогих машин:");
        carList.stream().sorted(Comparator.comparing(Car::getPrice).reversed()).limit(3).forEach(System.out::println);
        // Средний пробег всех машин
        System.out.println("Средний пробег всех машин:");
        System.out.println(carList.stream().mapToDouble(car -> (double) car.getMileage()).average().orElse(0.0));
        // Группировка машин по производителю
        Map<String, List<Car>> grouped = carList.stream().collect(Collectors.groupingBy(Car::getManufacturer));
        System.out.println("Группировка машин по производителю:");
        for(String key: grouped.keySet()) System.out.println(key + ": " + grouped.get(key));

        // 5 пункт
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("ПУНКТ 5");
        CarDealership dealership = new CarDealership();
        loop:
        while(true){
            System.out.println("Выберите действие:");
            System.out.println("1 -- Добавить машину в автоцентр");
            System.out.println("2 -- Найти все машины указанного производителя");
            System.out.println("3 -- Вывести среднюю цену машин определённого типа");
            System.out.println("4 --  Вернуть список машин, отсортированных по году выпуска (от новых к старым)");
            System.out.println("5 -- Вывести количество машин каждого типа");
            System.out.println("6 -- Вывести самую старую и самую новую машину в наличии");
            System.out.println("quit -- Завершить");

            String input = scanner.nextLine();

            switch (input){
                case "1":
                    System.out.println("Введите VIN:");
                    String vin = scanner.nextLine();
                    while (vin.isBlank()){
                        System.out.println("VIN не может быть пустым");
                        System.out.println("Введите VIN:");
                        vin = scanner.nextLine();
                    }
                    System.out.println("Введите модель:");
                    String model = scanner.nextLine();
                    while (model.isBlank()){
                        System.out.println("Модель не может быть пустой");
                        System.out.println("Введите модель:");
                        model = scanner.nextLine();
                    }
                    System.out.println("Введите производителя:");
                    String manufacturer = scanner.nextLine();
                    while (manufacturer.isBlank()){
                        System.out.println("Производитель не может быть пустым");
                        System.out.println("Введите производителя:");
                        manufacturer = scanner.nextLine();
                    }
                    System.out.println("Введите год изготовления:");
                    boolean flag = true;
                    int year = 0;
                    while(flag){
                        try{
                            year = Integer.parseInt(scanner.nextLine());
                            flag = false;
                        }
                        catch (NumberFormatException ex){
                            System.out.println("Год изготовления должен быть числом");
                            System.out.println("Введите год изготовления:");
                        }
                    }
                    System.out.println("Введите пробег:");
                    flag = true;
                    int mileage = 0;
                    while(flag){
                        try{
                            mileage = Integer.parseInt(scanner.nextLine());
                            flag = false;
                        }
                        catch (NumberFormatException ex){
                            System.out.println("Пробег должен быть числом");
                            System.out.println("Введите пробег:");
                        }
                    }
                    System.out.println("Введите цену:");
                    flag = true;
                    int price = 0;
                    while(flag){
                        try{
                            price = Integer.parseInt(scanner.nextLine());
                            flag = false;
                        }
                        catch (NumberFormatException ex){
                            System.out.println("Цена должна быть числом");
                            System.out.println("Введите цену:");
                        }
                    }
                    System.out.println("Введите тип машины (SEDAN, SUV, ELECTRIC)");
                    String type = scanner.nextLine();
                    while(!type.equals("SEDAN") && !type.equals("SUV") && !type.equals("ELECTRIC")){
                        System.out.println("Тип машины должен быть SEDAN, SUV или ELECTRIC");
                        System.out.println("Введите тип машины (SEDAN, SUV, ELECTRIC)");
                        type = scanner.nextLine();
                    }
                    Car car = new Car(vin, model, manufacturer, year, mileage, price, Car.Type.valueOf(type));
                    if(dealership.append(car)) System.out.println("Машина успешно добавлена");
                    else System.out.println("VIN не может повторяться у разных машин");
                    break;
                case "2":
                    System.out.println("Введите производителя:");
                    String manufacturer1 = scanner.nextLine();
                    while (manufacturer1.isBlank()){
                        System.out.println("Производитель не может быть пустым");
                        System.out.println("Введите производителя:");
                        manufacturer1 = scanner.nextLine();
                    }
                    List<Car> carsList = dealership.findByManufacturer(manufacturer1);
                    if(carsList.isEmpty()) System.out.println("Машин с таким производителем нет");
                    else{
                        System.out.println("Машины с производителем " + manufacturer1 + ":");
                        carsList.forEach(System.out::println);
                    }
                    break;
                case "3":
                    System.out.println("Введите тип машины (SEDAN, SUV, ELECTRIC)");
                    String type1 = scanner.nextLine();
                    while(!type1.equals("SEDAN") && !type1.equals("SUV") && !type1.equals("ELECTRIC")){
                        System.out.println("Тип машины должен быть SEDAN, SUV или ELECTRIC");
                        System.out.println("Введите тип машины (SEDAN, SUV, ELECTRIC)");
                        type1 = scanner.nextLine();
                    }
                    double avg = dealership.getAveragePrice(Car.Type.valueOf(type1));
                    System.out.println("Средняя цена с типом " + type1 + ": " + avg);
                    break;
                case "4":
                    List<Car> result = dealership.getSortedList();
                    result.forEach(System.out::println);
                    break;
                case "5":
                    System.out.println("Количество машин каждого типа:");
                    Map<Car.Type, Long> numbers = dealership.getNumberOfCars();
                    for(Car.Type key: numbers.keySet()) System.out.println(key + ": " + numbers.get(key));
                    break;
                case "6":
                    System.out.println("Самая старая машина:");
                    System.out.println(dealership.getTheOldestCar());
                    System.out.println("Самая новая машина:");
                    System.out.println(dealership.getTheNewestCar());
                    break;
                case "quit":
                    break loop;
                default:
                    System.out.println("Такой опции нет");
                    break;
            }
        }
    }
}