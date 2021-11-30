/**
 * "1. Basics of software code development". Циклы.
 *
 * Данный класс включает в себя методы, реализующие решения задач из пункта "Циклы".
 * Название метода совпадает с номером задачи (task_1 для 1ой задачи, task_2 для 2ой и т.д.).
 * Во время решения не обработчики исключений и другие, не предусмотренные заданием конструкции.
 * В методе main реализуем вызовы методов с печатью результата в консоль.
 *
 * @author Пригоряну Виктор.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Loops {

    /**
     * "1. Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
     * все числа от 1 до введенного пользователем числа."
     *
     * Метод не принимает значение целого положительного числа, а получает из ввода из консоли
     * для пполучения этого числа используется java.util.Scanner
     * так как при вычислении результата можно выйти из границ int, метод возвращает значение типа BigInteger
     * обработка исключений, связанных с вводом, отсутсвует
     */
    public static BigInteger task_1() {
        //получим введеное пользователем число в переменную n
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int n = in.nextInt();
        in.close();
        // получим сумму первых n чисел, используя цикл и переменную result типа BigInteger
        BigInteger result = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            result = result.add(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * "2. Вычислить значения функции на отрезке [а,b] c шагом h: x при x > 2 и -x при х <= 2"
     *
     * Поскольку использование массивов и других структур данных не предусмотрено, при каждой итерации цикла результат
     * будет печататься в консоль
     */
    public static void task_2(double a, double b, double h) {
        for (double x = a; x <= b ; x += h) {
            if (x <= 2){
                System.out.println(-x);
            }
            else {
                System.out.println(x);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Task_1:");
        System.out.println(task_1());                       // при вводе 1_000_000 получаем 500000500000 (выход за int)
        System.out.println("\nTask_2:");
        task_2(-3.14,3.32,1.1);
    }
}
