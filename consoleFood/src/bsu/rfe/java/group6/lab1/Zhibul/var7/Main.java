package bsu.rfe.java.group6.lab1.Zhibul.var7;

import java.util.Arrays;

public class Main {
    private final static String delim = "===========================================";

    // Конструктор класса отсутствует!!!
    // Главный метод главного класса
    public static void main(String[] args) {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int itemsSoFar = 0;
        boolean caloriesRequired = false;
        for (String arg : args) {
            String[] parts = arg.split("/");
            // У сыра дополнительных параметров нет
            // У яблока – 1 параметр, который находится в parts[1]

            switch (parts[0]) {
                case "Cheese" -> breakfast[itemsSoFar] = new Cheese();
                case "Apple" -> {
                    try {
                        breakfast[itemsSoFar] = new Apple(Apple.AppleSize.valueOf(parts[1].toUpperCase()));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("А яблоко-то безразмерное... Нет у меня такого :(");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Яблока " + parts[1] + " у меня нет :(");
                        continue;
                    }
                }
                case "IceCream" -> {
                    try {
                        breakfast[itemsSoFar] = new IceCream(IceCream.SyrupType.valueOf(parts[1].toUpperCase()));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Не хочу мороженое без сиропа, оставлю в холодильнике");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println(parts[1] + " мороженое у меня закончилось, надо бы купить ");
                        continue;
                    }
                }
                case "-calories" -> {
                    caloriesRequired = true;
                }
            }
            itemsSoFar++;
// ... Продолжается анализ других продуктов для завтрака
        }

        Arrays.sort(breakfast, new FoodOnlyIceCreamCmp());
        System.out.println(delim);
        printArray("Меню на сегодняшний завтрак", breakfast);
        System.out.println(delim);

        if (caloriesRequired)
            System.out.println("Калорийность завтрака: " + calculateCalories(breakfast));
// Перебор всех элементов массива
        for (Food item : breakfast)
            if (item != null)
// Если элемент не null – употребить продукт
                item.consume();
            else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                break;
        System.out.println("Всего хорошего!");
    }

    private static void printArray(String msg, Food[] breakfast) {
        System.out.println(msg);
        for (Food food : breakfast) {
            if (food != null)
                System.out.println(food);
        }
    }

    private static int calculateCalories(Food[] breakfast) {
        int sum = 0;
        for (Food food : breakfast) {
            if (food != null) {
                sum += food.calculateCalories();
            }
        }
        return sum;
    }
}

