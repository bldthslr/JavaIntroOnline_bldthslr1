package u4_2_Agregation_And_Composition.task3;

import java.util.Arrays;

/**
 * Класс области.
 * Область состоит из нескольких районов.
 * Областной центр должен быть среди городов одного из районов, иначе выбрасывается исключение.
 * Площадь области состоит из площади входящих районов.
 */
public class State {
    private String name;
    private double area;
    private District[] districts;
    private City stateCenter;


    // Конструктор с переменным числом аргументов (районов)
    public State(String name, City stateCenter, District... districts) {
        this.name = name;
        this.districts = districts;
        // Площадь области равна сумме площади районов
        for (District district : this.districts) {
            area += district.getArea();
        }
        // Проверим, есть ли в районах переданный областной центр
        // создадим флаг для проверки
        boolean isInDistricts = false;
        // В цикле проверим, есть ли объект обл. центра в среди городов в районах области
        for (District district : this.districts) {
            City[] cities = district.getCities();
            for (City city : cities) {
                if (city.equals(stateCenter)) {
                    isInDistricts = true;
                    break;
                }
            }
            if (isInDistricts) {
                break;
            }
        }
        // Если облцентр в районах не найдена, выкинем исключение
        if (!isInDistricts) {
            throw new RuntimeException("this State center does not exist in any district of the State!");
        }
        this.stateCenter = stateCenter;
    }

    // Геттеры

    public District[] getDistricts() {
        return districts;
    }
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public City getStateCenter() {
        return stateCenter;
    }



    // Сеттеры

    public void setName(String name) {
        this.name = name;
    }
    public void setArea(double area) {
        this.area = area;
    }

    // Изменение областного центра. Если города нет в районах данной области, то будет выброшено исключение
    public void setStateCenter(City stateCenter) {
        // Проверим, есть ли в районах переданный областной центр
        // создадим флаг для проверки
        boolean isInDistricts = false;
        // В цикле проверим, есть ли объект обл. центра в среди городов в районах области
        for (District district : districts) {
            City[] cities = district.getCities();
            for (City city : cities) {
                if (city.equals(stateCenter)) {
                    isInDistricts = true;
                    break;
                }
            }
            if (isInDistricts) {
                break;
            }
        }
        // Если облцентр в районах не найдена, выкинем исключение
        if (!isInDistricts) {
            throw new RuntimeException("this State center does not exist in any district of the State!");
        }
        this.stateCenter = stateCenter;
    }

    // Добавление района в область
    public void addDistrict(District district) {
        districts = Arrays.copyOf(districts, districts.length + 1);
        districts[districts.length - 1] = district;
    }

    @Override
    public String toString() {
        return "State " + name + ", area = " + area + ".";
    }
}
