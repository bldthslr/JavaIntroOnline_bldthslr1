/**
 * "1. Basics of software code development". Линейный программы.
 *
 * Данный класс включает в себя методы, реализующие решения задач из пункта "Линейные программы".
 * Название метода совпадает с номером задачи (task_1 для 1ой задачи, task_2 для 2ой и т.д.).
 * Во время решения не используются конструкции ветвления, циклов, а так же обработчики исключений и другие конструкции.
 * В методе main реализуем вызовы методов с печатью результата в консоль.
 *
 * @author Пригоряну Виктор.
 */

public class LinearPrograms {

    /**
     * 1. "Найдите значение функции: z = ( (a – 3 ) * b / 2) + c."
     */
    public static double task_1(double a, double b, double c) {
        double z = ((a - 3) * b / 2) + c;
        return z;
    }

    /**
     * 2. "Вычислить значение выражения по формуле (все переменные принимают действительные значения):
     * (b + sqrt(b^2 + 4ac) / 2a - a^3 * c + b^-2"
     *
     * Для взятия квдаратного корня и вычисления степени используются методы из класса Math
     */
    public static double task_2(double a, double b, double c) {
        return ((b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a)) - Math.pow(a, 3) * c + Math.pow(b, -2);
    }

    /**
     * 3. "Вычислить значение выражения по формуле (все переменные принимают действительные значения):
     *  ((sin(x) + cos(y)) / (cos(x) - sin(y))) * tg(xy)"
     *
     * Для вычисления тригонометрических функций используются методы из класса Math
     */
    public static double task_3(double x, double y) {
        return ((Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y))) * Math.tan(x * y);
    }

    /**
     * 4. "Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
     * дробную и целую части числа и вывести полученное значение числа"
     *
     * Данное решение не производит проверку данного действительного числа R на соответствие условию
     * и некорректно работает, если R не вида nnn.ddd.
    */
    public static double task_4(double R) {
        // Возьмем целую(nnn) и дробную(ddd) часть в виде целых чисел
        int nnn = (int) R;
        int ddd = (int) (R * 1000 % 1000);
        // Получим новую дробную часть
        double Result = (double) nnn / 1000;
        // И прибавим новую целую часть.
        Result += ddd;
        return Result;
    }

    /**
     * 5. "Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
     * данное значение длительности в часах, минутах и секундах в следующей форме:
     * ННч ММмин SSc."
     *
     * Незначащие нули в результирующую строку не добавляются.
     */
    public static String task_5(int T) {
        // Вычислим значения часов, минут и секунд
        int hours = T / 3600;
        int minutes = T % 3600 / 60;
        int seconds = T % 60;
        // Соберем всё в результирующую строку
        return hours + "ч " + minutes + "мин " + seconds + "c.";
    }

    /**
     * 6. "Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
     * принадлежит закрашенной области, и false — в противном случае"
     *
     * Закрашенную область можно разделить на 2 "простые" фигуры - квадрат со сторонами х = -2, x = 2, y = 0, y = 4
     * и прямоугольник со сторонами x = -4, x = 4, y = -3, y = 0
     * Точка принадлежит закрашенной области, если принадлежит одной из этих фигур
     * Таким образом можно составить логическое условие для каждой из фигур, которое будет возвращать результат
     */
    public static boolean task_6(double x, double y) {
        boolean square = ((0 <= y) && (y <= 4) && (-2 <= x) && (x <= 2));
        boolean rectangle = (-3 <= y) && (y <= 0) && (-4 <= x) && (x <= 4);
        return square || rectangle;
    }


    /**
     * Дописать про метод main :)
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Task_1:");
        System.out.println(task_1(1, 2, 3));            // z = 1.0
        System.out.println(task_1(1.5, 2.5, 3.5));      // z = 1.625
        System.out.println("\nTask_2:");
        System.out.println(task_2(1,2,3));              // 0.25
        System.out.println(task_2(2,4,3));              // -21.35636116991581
        System.out.println(task_2(0,2,3));              // деление на ноль, результат +∞
        System.out.println(task_2(-1,2,3));             // sqrt(-x), результат NaN
        System.out.println("\nTask_3:");
        System.out.println(task_3(1, 1));                  // -7.145445549638803
        System.out.println(task_3(Math.PI/2, 0));          // Результатом должно быть NaN, т.к. +∞ * 0, но поулчается ноль из-за умножения очень большого числа на ноль
        System.out.println(task_3(0, Math.PI));               // -0.0, из-за умножения -1 и 0
        System.out.println("\nTask_4:");
        System.out.println(task_4(354.186));                  // 186.354
        System.out.println(task_4(003.010));                  // 10.003
        System.out.println(task_4(10.0256));                  // 25.01, пример некорректной работы
        System.out.println("\nTask_5:");
        System.out.println(task_5(3600));                     // 1ч 0мин 0c.
        System.out.println(task_5(3605));                     // 1ч 0мин 5c.
        System.out.println(task_5(3665));                     // 1ч 1мин 5c.
        System.out.println(task_5(27183));                    // 7ч 33мин 3c.
        System.out.println("\nTask_6:");
        System.out.println(task_6(-4, 0));                 // true
        System.out.println(task_6(0, 0));                  // true
        System.out.println(task_6(4.5, 1));                // false
    }
}
