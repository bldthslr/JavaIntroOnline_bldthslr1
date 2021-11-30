package u4_1_SimpleClasses.task6;

/**
 * Использование клсаа "Counter".
 */
public class TimeUsage {
    public static void main(String[] args) {
        // Создадим новый объект Time без передачи параметров
        Time testTime = new Time();
        System.out.println(testTime.getTime());             // 00:00.00
        // Создадим объект, передав параметры
        testTime = new Time(15,23,36);
        System.out.println(testTime.getTime());             // 15:23.36
        // Зададим значения сеттерами
        testTime.setSeconds(20);                            // 15:23.20
        testTime.setMinutes(64);                            // Переполнение, 15:00.20
        testTime.setHours(25);                              // Переполнение, 00:00.20
        System.out.println(testTime.getTime());             // 00:00.20
        System.out.println(testTime.getHours() + " "  + testTime.getMinutes() + " " +
                testTime.getSeconds());                     // 0 0 20
        // Зададим значение сеттером setTime
        testTime.setTime(15,20,30);
        System.out.println(testTime.getTime());             // 15:20.30
        // Изменим значения при помощи addTime
        testTime.addTime(40,150,3853);
        System.out.println(testTime.getTime());             // 10:54.43
    }
}
