package u4_1_SimpleClasses.task5;

/**
 * Использование клсаа "Counter".
 */
public class CounterUsage {
    public static void main(String[] args) {
        // Создадим счетчик со значениями по умолчанию
        Counter counter = new Counter();
        System.out.println(counter.getCount());              //0
        // Увеличим значения счетчика, пока не дойдем до верхней границы и не переполним его
        while (counter.getCount() >= -1) {
            counter.increase();
        }                                                    // Warning! overflow at the upper bound!
        System.out.println(counter.getCount());              // -9999999
        // Создадим счетчик, и зададим значение счетчика по умолчанию
        counter = new Counter(-500);
        counter.decrease();
        System.out.println(counter.getCount());              // -501
        // Создадим счетчик и зададим все параметры (значение и границы)
        counter = new Counter(0, -100, 100);
        while (counter.getCount() != 1) {
            counter.decrease();
        }                                                    // Warning! overflow at the lower bound!
        System.out.println(counter.getCount());              // 1
        // Пример исключения, нижняя граница больше верхней
        try {
            counter = new Counter(0, 5, -5);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // Пример исключения, параметр значения за границей счетчика
        try {
            counter = new Counter(-10_000_000);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        /*
        Вывод в консоль:
        "0
        Warning! overflow at the upper bound!
        -9999999
        -501
        Warning! overflow at the lower bound!
        1
        The lower limit of the range should be less than the upper one!
        The counter value must be in the range! "
         */
    }
}
