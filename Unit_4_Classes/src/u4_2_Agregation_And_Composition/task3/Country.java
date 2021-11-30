package u4_2_Agregation_And_Composition.task3;

import java.util.Arrays;

/**
 * "3. Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
 * столицу, количество областей, площадь, областные центры."
 *
 * Страна состоит из областей, области из районов, а районы из городов.
 * Столица страны должна быть среди областных центров входящих в неё областей, иначе выбрасывается исключение.
 * Площадь страны состоит из входящих в неё областей
 */
public class Country {
    private String name;
    private double area;
    private State[] states;
    private City capital;

    // Конструктор с переменным числом аргументов (областей)
    public Country(String name, City capital, State... states) {
        this.name = name;
        this.states = states;
        // Площадь страны равна площади входящих в неё областей
        for (State state : this.states) {
            area += state.getArea();
        }
        //Проверим, есть ли столица среди областных центров, и, если нет, выбросим исключение
        boolean isInState = false;
        for (State state : states) {
            if (capital.equals(state.getStateCenter())) {
                isInState = true;
                break;
            }
        }
        // Если среди обл. центров столицы нет, выбросим исключение
        if (!isInState) {
            throw new RuntimeException("this capital does not exist in any district of the State!");
        }
        this.capital = capital;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public State[] getStates() {
        return states;
    }

    public City getCapital() {
        return capital;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setArea(double area) {
        this.area = area;
    }

    // Добавление области в город
    public void addState(State state) {
        states = Arrays.copyOf(states, states.length + 1);
        states[states.length - 1] = state;
    }

    // Методы для вывода на консоль, описанные в условие
    // Вывод столицы на консоль
    public void printCapital() {
        System.out.println("Capital is:");
        System.out.println(getCapital());
        System.out.println();
    }

    // Вывод областей на консоль, используя метод toString
    public void printStates() {
        StringBuilder rez = new StringBuilder("List of states:\n");
        for (State state : states) {
            rez.append(state.toString()).append("\n");
        }
        System.out.println(rez);
    }

    // Вывод районов на консоль, используя метод toString
    public void printDistricts() {
        StringBuilder rez = new StringBuilder("List of districts:\n");
        for (State state : states) {
            for (District district : state.getDistricts()) {
                rez.append(district.toString()).append("\n");
            }
        }
        System.out.println(rez);
    }
    // Вывод городов на консоль, используя метод toString

    public void printCities() {
        StringBuilder rez = new StringBuilder("List of Cities:\n");
        for (State state : states) {
            for (District district : state.getDistricts()) {
                for (City city : district.getCities())
                    rez.append(city.toString()).append("\n");
            }
        }
        System.out.println(rez);
    }

    // Вывод площади на консоль
    public void printArea() {
        System.out.println("Area is:");
        System.out.println(getArea());
        System.out.println();
    }

    // Вывод обл. центров на консоль
    public void printStateCenters() {
        StringBuilder rez = new StringBuilder("List of state centers:\n");
        for (State state : states) {
            rez.append(state.getStateCenter().toString()).append("\n");
        }
        System.out.println(rez);
    }


    // Переопределим метод toString
    @Override
    public String toString() {
        return "Country " + name + ", area = " + area + ".";
    }
}
