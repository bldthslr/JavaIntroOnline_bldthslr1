package u4_2_Agregation_And_Composition.task3;

import java.util.Objects;

/**
 * Класс города
 * Имеет два поля - название и площадь.
 * В данном классе переопределен не только метод toString, но и equals и hashCode.
 * Переопределение данных методов необходимо для корректного сравнения объектов городов.
 */
public class City {
    private String name;
    private double area;

    // Конструктор
    public City(String name, double area) {
        this.name = name;
        this.area = area;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }


    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setArea(double area) {
        this.area = area;
    }


    // Переопределим методы toString, equals и hashCode
    @Override
    public String toString() {
        return "City " + name + ", area = " + area + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Double.compare(city.getArea(), getArea()) == 0 && Objects.equals(getName(), city.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getArea());
    }
}
