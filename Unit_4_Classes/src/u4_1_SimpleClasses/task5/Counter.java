package u4_1_SimpleClasses.task5;
/**
 * "5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
 * на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
 * произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
 * позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса."
 *
 *  Код, демонстрирующий возможности класса предстваленн в классе "CounterUsage".
 */
public class Counter {
    private int count;
    //Границы диапазона
    private int lowerLimit;
    private int upperLimit;

    // Конструктор без параметров (значения по умолчанию)
    public Counter() {
        count = 0;
        lowerLimit = -9_999_999;
        upperLimit = 9_999_999;
    }

    // Конструктор с параметром начальной велечины счетчика (границы по умолчанию)
    public Counter(int count) throws IllegalArgumentException {
        this.count = count;
        lowerLimit = -9_999_999;
        upperLimit = 9_999_999;
        if ((count < lowerLimit) || (count > upperLimit)) {
            throw new IllegalArgumentException("The counter value must be in the range!");
        }
    }

    // Конструктор с параметрами (велечина счетчика, верхний и нижний диапазон
    public Counter(int count, int lowerLimit, int upperLimit) throws IllegalArgumentException {
        if (lowerLimit >= upperLimit) {
            throw new IllegalArgumentException("The lower limit of the range should be less than the upper one!");
        }
        if ((count < lowerLimit) || (count > upperLimit)) {
            throw new IllegalArgumentException("The counter value must be in the range!");
        }
        this.count = count;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    // Геттер
    public int getCount() {
        return count;
    }

    // Увеличение
    public void increase() {
        // При переполнении по верхней границе напечатаем предупреждение, и переведм значение счетчика на нижнюю границу
        if (count == upperLimit) {
            System.out.println("Warning! overflow at the upper bound!");
            count = lowerLimit;
        }
        else {
            count++;
        }
    }

    //Уменьшение
    public void decrease() {
        // При переполнении по нижней границе напечатаем предупреждение, и переведм значение счетчика на верхнюю границу
        if (count == lowerLimit) {
            System.out.println("Warning! overflow at the lower bound!");
            count = upperLimit;
        }
        else {
            count--;
        }
    }


}
