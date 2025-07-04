package org.example;


import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Лямбда-выражения
        // 1
        System.out.println("Лямбда выражение для интерфейса Printable:");
        Printable message = () -> System.out.println("point 1");
        message.print();

        // 2
        System.out.println("Лямбда выражение, которое возвращает значение true, если строка не null");
        Predicate<String> predicate1 = str -> str != null;
        System.out.println(predicate1.test("test"));
        System.out.println(predicate1.test(null));

        System.out.println("Лямбда выражение, которое проверяет, что строка не пуста");
        Predicate<String> predicate2 = str -> !str.isBlank();
        System.out.println(predicate2.test("test"));
        System.out.println(predicate2.test(" "));

        System.out.println("Проверка, что строка не null и не пуста, используя метод and()");
        Predicate<String> predicate3 = predicate1.and(predicate2);
        System.out.println(predicate3.test("test"));
        System.out.println(predicate3.test(null));
        System.out.println(predicate3.test(" "));

        // 3
        // Строка начинается с J
        Predicate<String> predicateJ = str -> str.startsWith("J");
        // Строка начинается с N
        Predicate<String> predicateN = str -> str.startsWith("N");
        // Строка заканчивается на A
        Predicate<String> predicateA = str -> str.endsWith("A");
        // Строка начинается с J или N и заканчивается на A
        Predicate<String> combined = predicateA.and(predicateJ.or(predicateN));
        System.out.println("Проверка, что строка начинается буквой “J”или “N” и заканчивается “A”");
        System.out.println(combined.test("JPA")); //true
        System.out.println(combined.test("NBA")); //true
        System.out.println(combined.test("JDK")); //false
        System.out.println(combined.test("Nm")); //false
        System.out.println(combined.test("KA")); //false

        // 4
        // Создание объекта ящика
        HeavyBox box = new HeavyBox(10);
        Consumer<HeavyBox> consumer1 = obj -> System.out.println("Отгрузили ящик с весом " + obj.getWeight());
        Consumer<HeavyBox> consumer2 = obj -> System.out.println("Отправляем ящик с весом " + obj.getWeight());
        Consumer<HeavyBox> consumer3 = consumer1.andThen(consumer2);
        System.out.println("Работа с интерфейсом Consumer:");
        consumer3.accept(box);

        // 5
        Function<Integer, String> function = number -> {
            if(number > 0) return "Положительное число";
            else if(number < 0) return "Отрицательное число";
            else return "Ноль";
        };
        System.out.println("Работа с интерфейсом Function:");
        System.out.println(function.apply(1));
        System.out.println(function.apply(0));
        System.out.println(function.apply(-1));

        // 6
        Random random = new Random();
        Supplier<Integer> supplier = () -> random.nextInt(0, 11);
        System.out.println("Работа с интерфейсом Supplier:");
        System.out.println(supplier.get());

        // Работа с аннотациями и рефлексией
        // 1
        System.out.println("Поиск всех элементов, помеченных аннотацией DeprecatedEx:");
        DeprecatedClass deprecatedClass = new DeprecatedClass();
        AnnotationHandler.process(deprecatedClass);

        // 2
        JsonData data = new JsonData("Строка", 10.5);
        System.out.println("Сериализация в JSON:");
        System.out.println(JsonSerializer.getJson(data));
    }
}