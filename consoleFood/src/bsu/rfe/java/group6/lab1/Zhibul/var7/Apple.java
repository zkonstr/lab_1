package bsu.rfe.java.group6.lab1.Zhibul.var7;

public class Apple extends Food {
    // Новое внутреннее поле данных РАЗМЕР
    enum AppleSize {МАЛЕНЬКОЕ, СРЕДНЕЕ, БОЛЬШОЕ}

    //private String size;
    AppleSize size;

    public Apple(AppleSize size) {
// Вызвать конструктор предка, передав ему имя класса
        super("Яблоко");
// Инициализировать размер яблока
        this.size = size;
    }

    // Переопределить способ употребления яблока
    public void consume() {
        System.out.println(this + " съедено");
    }

    // Селектор для доступа к полю данных РАЗМЕР
    public AppleSize getSize() {
        return size;
    }

    // Модификатор для изменения поля данных РАЗМЕР
    public void setSize(AppleSize size) {
        this.size = size;
    }

    // Переопределѐнная версия метода equals(), которая при сравнении
// учитывает не только поле name (Шаг 1), но и проверяет совместимость
// типов (Шаг 2) и совпадение размеров (Шаг 3)
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Apple)) return false; // Шаг 2
            return size.equals(((Apple) arg0).size); // Шаг 3
        } else
            return false;
    }

    // Переопределѐнная версия метода toString(), возвращающая не только
// название продукта, но и его размер
    public String toString() {
        return super.toString() + " " + size.toString().toLowerCase();
    }

    @Override
    public int calculateCalories() {
        return switch (this.size) {
            case МАЛЕНЬКОЕ -> 50;
            case СРЕДНЕЕ -> 100;
            case БОЛЬШОЕ -> 150;
        };
    }
}