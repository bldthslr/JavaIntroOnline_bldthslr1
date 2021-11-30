package u4_2_Agregation_And_Composition.task3;

import java.util.Arrays;

/**
 * Класс района.
 * В район входит несколько городов.
 * В отличии от страны и области, площадь района задается в конструкторе, и не зависит от площади входящих городов.
 * Однако, если заданная площадь района меньше площади входящих в него городов, будет выброшено исключение.
 */
public class District {
    private String name;
    private double area;
    private City[] cities;

    // Конструктор с переменным числом аргументов (городов)
    public District(String name, double area, City... cities) {
        this.name = name;
        this.cities = cities;
        // Проверим, является ли заданная в конструкторе площадь больше площади городов, и, если нет, выбросим исключение
        double citiesArea = 0;
        for (City city : this.cities) {
            citiesArea += city.getArea();
        }
        if (citiesArea < area) {
            throw new RuntimeException("The specified area of the district is less than the area of the cities included in it!");
        }
        this.area = area;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public City[] getCities() {
        return cities;
    }


    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }


    // Добавление города в район
    public void addCity(City city) {
        cities = Arrays.copyOf(cities, cities.length + 1);
        cities[cities.length - 1] = city;
    }


    @Override
    public String toString() {
        return "District " + name + ", area = " + area + ".";
    }
}
