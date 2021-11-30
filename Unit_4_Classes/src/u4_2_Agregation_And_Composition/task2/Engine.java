package u4_2_Agregation_And_Composition.task2;

/**
 * Класс для описания двигателя, использующийся в классе Car.
 * Поля:
 * name - навзвание двигателя;
 * power - мощность в л/с;
 * capacity - объем двигателя (в литрах);
 * numberOfCylinders - количество цилиндров;
 * fuelConsumption - расход топлива (в л/100км).
 *
 * В конструкторе не проверяются значения параметров на валидонсть.
 * В данном классе переопределен метод toString.
 */
public class Engine {
    private String name;
    private int power;
    private double capacity;
    private int numberOfCylinders;
    private double fuelConsumption;

    // Конструктор
    public Engine(String name, int power, double capacity, int numberOfCylinders, double fuelConsumption) {
        this.name = name;
        this.power = power;
        this.capacity = capacity;
        this.numberOfCylinders = numberOfCylinders;
        this.fuelConsumption = fuelConsumption;
    }

    // Геттеры
    public int getPower() {
        return power;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return "Engine "                 + name                 + ":\n" +
                "Power = "               + power                + "HP;\n" +
                "Capacity = "            + capacity             + "L;\n" +
                "Number Of Cylinders = " + numberOfCylinders    + ";\n" +
                "Fuel Consumption = "    + fuelConsumption      + "L/100km.";
    }
}
