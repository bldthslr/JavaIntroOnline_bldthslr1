package u2_4_Decompositions;

import java.util.Scanner;

/**
 * "4. На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
 * из пар точек самое большое расстояние. Указание. Координаты точек занести в массив."
 *
 * Количество точек n считывается из потока ввода.
 * Далее каждая точка считывается из потока ввода в виде двух чисел, введенных через пробел (например "3 5")
 * Точки хранятся в массиве в виде a[0] = x1, a[1] = y1, a[2] = x2, a[3] = y2 и т.д.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_4 {
    public static void main(String[] args) {
        // Считаем количество точек n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of fractions n: ");
        int n = in.nextInt();
        // Объявим массив для хранения точек
        double[] a = new double[n * 2];
        // Заполним этот массив из потока ввода
        for (int i = 0; i < n * 2; i += 2) {
            System.out.println("Enter the coordinates X and Y of the " + ((i + 2) / 2) + "st point separated by a space:");
            a[i] = in.nextDouble();
            a[i+1] = in.nextDouble();
        }
        in.close();

        // Выведем результат на экран
        System.out.println("The area of a regular hexagon with a given side: ");
        System.out.println(result(maxDistance(a)));
    }

    /**
     * Находит расстояние между двумя точками на плоскости
     * @param x1 - координата x первой точки
     * @param y1 - координата y первой точки
     * @param x2 - координата x второй точки
     * @param y2 - координата y второй точки
     * @return - расстояние между точками
     */
    public static double twoPointDistance (double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2 - y1, 2));
    }

    /** Сохраним результат в String
     * @param a - массив
     * @return - строка с результатом
     */
    public static String result(double a[]) {
        return "Distance between points (x1 = " + a[0] + ", y1 = " + a[1] + ") and (x2 = " + a[2] + ", y1 = " + a[3] +
                "):\n" + a[4];
    }

    /**
     * В массиве, заполненном как a[0] = x1, a[1] = y1, a[2] = x2, a[3] = y2 и т.д., находит самое большое расстояние
     * между двумя точками, а так же сохраняет координаты этих точек
     * @param a - массив
     * @return - Массив из 5 элементов, где первые 4 - координаты двух точек, а 5 - расстояние между точками
     */
    public static double[] maxDistance (double[] a) {
        double[] result = new double[5];
        double curDst;
        double x1, y1, x2, y2;
        for (int i = 0; i < a.length; i += 2) {
            x1 = a[i];
            y1 = a[i+1];
            for (int j = 0; j < a.length; j += 2) {
                if (i != j) {
                    x2 = a[j];
                    y2 = a[j+1];
                    curDst = twoPointDistance(x1, y1, x2, y2);
                    if (curDst > result[4]) {
                        result[0] = x1;
                        result[1] = y1;
                        result[2] = x2;
                        result[3] = y2;
                        result[4] = curDst;
                    }
                }
            }
        }
        return result;
    }
}
