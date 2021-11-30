package u4_1_SimpleClasses.task1;

/**
 * "1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
 * переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
 * наибольшее значение из этих двух переменных."
 *
 * Тип переменных - int.
 *
 * Пример использования данного класса предствален в классе "Test1Usage".
 */
public class Test1 {
    private int first;
    private int second;

    public void printFirst() {
        System.out.println(first);
    }

    public void printSecond() {
        System.out.println(second);
    }

    public void changeFirst(int x) {
        first = x;
    }

    public void changeSecond(int x) {
        second = x;
    }

    public void printSum() {
        System.out.println(first + second);
    }

    public void printMax() {
        if (first > second) {
            printFirst();
        }
        else printSecond();
    }
}
