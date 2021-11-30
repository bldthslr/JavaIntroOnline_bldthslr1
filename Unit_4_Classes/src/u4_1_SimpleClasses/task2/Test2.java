package u4_1_SimpleClasses.task2;

/**
 * "2. Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
 * конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
 * класса."
 *
 * Тип переменных - int.
 *
 * Пример использования данного класса предствален в классе "Test2Usage".
 */
public class Test2 {
    private int first;
    private int second;

    // Конструктор с входными параметрами
    public Test2(int first, int second) {
        this.first = first;
        this.second = second;
    }

    // Конструктор, инициализирующий члены класса по умолчанию
    public Test2() {
        first = 1;
        second = -1;
    }

    // Геттеры
    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    // Сеттеры

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
