package u2_4_Decompositions;

import java.util.Scanner;

/**
 * "3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
 * треугольника."
 *
 * Длинна стороны a считываются из потока ввода.
 * Для подсчета площади шестиугольника используется формула нахождения площади правильного треугольника по стороне.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_3 {
    public static void main(String[] args) {
        // Считаем длинну стороны a из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number a: ");
        double a = in.nextDouble();
        // Выведем результат на экран
        System.out.println("The area of a regular hexagon with a given side: ");
        System.out.println(squareOfRegularHexagon(a));
    }

    /**
     * Метод нахождения площади правильного треугольника по стороне.
     * @param a - длинна стороны
     * @return - площадь треугольника со стороной а
     */
    public static double squareOfRegularTriangle (double a) {
        return (a * a * Math.sqrt(3)) / 4;
    }

    /**
     * Метод нахождения площади правильного шестиугольника при помощи формулы нахождения площади правильного
     * треугольника. Диагонали равностороннего шестиугольника делят его на 6 правильных треугольников.
     * @param a - длинна стороны
     * @return - площадь шестиугольника со стороной а
     */
    public static double squareOfRegularHexagon (double a) {
        return squareOfRegularTriangle(a) * 6;
    }
}
