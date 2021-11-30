package u4_1_SimpleClasses.task2;

/**
 * Использование класса Test2.
 */
public class Test2Usage {
    public static void main(String[] args) {
        // Создаем экземпляр класса без параметров
        Test2 test = new Test2();
        // Используем геттеры, чтобы вывести значение полей на экран
        System.out.println(test.getFirst() + " " + test.getSecond());    // 1 -1
        // Создаем новый экземпляр, передавая параметры
        test = new Test2(100, 500);
        System.out.println(test.getFirst() + " " + test.getSecond());    //100 500
        // Используем сеттеры
        test.setFirst(-500);
        test.setSecond(-100);
        System.out.println(test.getFirst() + " " + test.getSecond());    //-500 -100
    }
}
