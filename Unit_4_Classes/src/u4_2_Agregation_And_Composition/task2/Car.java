package u4_2_Agregation_And_Composition.task2;

import java.util.Arrays;

/**
 * 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 *
 * Класс автомобиль имеет поля:
 * Название брэнда и название модели типа String;
 * Двигатель типа двигатель;
 * Массив из 4 колес типа колесо;
 * Объем вместимости бензобака типа int;
 * Текущее количество топлива в бензобаке типа double.
 *
 * Конструктор в качестве параметров принимает почти все значения для полей, исключая текущуее количество топлива
 * (предпологается, что при создании объекта car бензобак полон).
 *
 * В качестве методов, кроме описанных в условии, добавленны геттеры, а так же переопределен метод toString.
 */
public class Car {
    private String model, brand;
    private Engine engine;
    private Wheel[] wheels = new Wheel[4];
    private int tankCapacity;
    private double currentTankCap;

    // Конструктор
    public Car(String model, String brand, Engine engine, Wheel wheel, int tankCapacity) {
        this.model = model;
        this.brand = brand;
        this.engine = engine;
        for (int i = 0; i < 4; i++) {
            this.wheels[i] = wheel;
        }
        this.tankCapacity = tankCapacity;
        this.currentTankCap = tankCapacity;
    }

    // Геттеры

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheel getWheels() {
        return wheels[0];
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public double getCurrentTankCap() {
        return currentTankCap;
    }

    // Замена колеса
    public String changeWheel (Wheel newWheel, int position) {
        if ((position < 0) || (position > 3)) {
            return "No replacement made, enter the correct position for the wheel!";
        }
        else {
            wheels[position] = newWheel;
            return "Replacement made successfully!";
        }
    }

    // Заправка
    public String refuel() {
        currentTankCap = tankCapacity;
        return "The car has been refueled!";
    }

    /** Поездка
    @param k - коэфицент умножения времени моделирования, например, при k == 1 машина "едет" в реальном времени,
    а при коэфиценте k = 3600 одна секунда реального времени равна оденому часу в моделируемом времени.
    @param  maxSpeed - максимальаня скорость авто в км/ч. В данном методе не реализовано ускорение, подразумевается,
    что машина сразу набирает максимальную скорость.
    Метод работает следующим образом:
    В цикле каждую секунду подсчитывается, сколько метров проехала машина (в метрах), сколько времени прошло (в секундах),
    и сколько топлива было потрачено (в литрах). Цикл завершает свою работу, когда топливный бак оказывается пуст.
    Поскольку, при высоких коэфицентах k за одну итерацию может быть потрачено топлива больше, чем есть в баке,
    добавленно дополнительное условие. При завершении "поездки" метод информирует, что поездка окончена и бак пуст.
     */
    public void drive(long k, int maxSpeed) {
        // Объявим необходимые переменные
        // Общее время поездки
        int timeLength = 0;
        // Общий путь поездки
        double path = 0;
        // Пройденный путь за 1 итерацию
        double iterationPath = 0;
        // Потраченное топливо за 1 итерацию, рассчитывается на основе пройденного пути за 1 итерацию.
        double iterationFuelConsumption = 0;
        // Объявляем о начале поездки
        System.out.println("Drive started!");
        // Цикл поездки автомобиля. Итерации будут продалжатся, пока не закончится топливо в баке.
        while (currentTankCap >= 0.1) {
            // Пауза в одну секунду, обеспечивающая работу одной итерации
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Пройденный путь за итерацию
            iterationPath = (maxSpeed / 3.6) * k;
            // Траты бензина за итерацию
            iterationFuelConsumption = engine.getFuelConsumption() / 100_000 * iterationPath;
            // Если траты бензина меньше, чем осталось в баке, то машина "проезжает" полный маршрут
            if (currentTankCap > iterationFuelConsumption) {
                // Общий пройденный путь
                path += iterationPath;
                // Общее время поездки
                timeLength += k;
                // Оставшиеся топливо в баке
                currentTankCap -= iterationFuelConsumption;
            }
            // Если траты бензина больше, то найдем коэфицент, который отражает оставшиеся затраты к общим
            else {
                // Коэфицент трат топлива к оставшимуся в баке
                double ratio = currentTankCap / iterationFuelConsumption;
                // Общий пройденный путь
                path += iterationPath * ratio;
                // Общее время поездки
                timeLength += k * ratio;
                // Оставшиеся топливо в баке
                currentTankCap -= iterationFuelConsumption * ratio;
            }
            // Вывод результата на экран
            System.out.println("Drive lasts " + (timeLength / 60) + " minutes. Car drove " + path + " meters. " +
                    "There are " + currentTankCap +  " liters of gasoline left in the gas tank");
        }
        // После того, как кончилось топливо, уведомим об окончании поездки.
        System.out.println("Drive is over! Fuel tank empty!");
    }

    @Override
    public String toString() {
        String formattedCurrentTankGap = String.format("%.2f", currentTankCap);
        return "_____________________________________________\n" +
                brand + " " + model + ":\n" +
                "Gas tank capacity: " + tankCapacity + "L;\n" +
                "The current amount of gasoline: " + formattedCurrentTankGap + "L;\n\n" +
                engine.toString() + "\n\nWheels:\n" +
                Arrays.toString(wheels) + "\n_____________________________________________";

    }
}
