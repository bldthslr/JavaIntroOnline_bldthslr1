package u2_4_Decompositions;

/**
 * "7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9."
 *
 * Числа a, b, c считываются из потока ввода. Эти числа должны быть целыми.
 * Числа взаимно простые, если их общий НОД = +-1.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */

public class Task_7 {
    public static void main(String[] args) {
        System.out.println(sumOfFactorials(1,9,2));
    }

    /**
     * Метол возвращает факториал числа a.
     * @param a - входное число
     * @return - его факториал
     */
    public static long factorial (int a) {
        long fact = 1;
        for (int i = 0; i < a; i++) {
            fact *= i+1;
        }
        return fact;
    }

    /**
     * Метод для подсчета суммы всех факториалов, начиная с числа first, заканчивая числом next, с шагом step.
     * @param first - нижняя граница диапазона
     * @param last - верхняя граница диапазона
     * @param step - шаг в диапазоне
     * @return - сумма факториалов по заданным условиям
     */
    public static long sumOfFactorials (int first, int last, int step) {
        long sum = 0;
        for (int i = first; i <= last; i += step) {
            sum += factorial(i);
        }
        return sum;
    }
}
