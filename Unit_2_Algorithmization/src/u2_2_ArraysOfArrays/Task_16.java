package u2_2_ArraysOfArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * "16. Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,..., n^2
 * так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между собой.
 * Построить такой квадрат."
 *
 * Размерность квадратной матрицы n считывается из потока ввода
 * Для построения магического квадрата используются три разных алгоритма:
 * 1) Для квадратов нечетного порядка - Индийский метод
 * 2) Для квадратов четно-четного порядка - метод квадратных рамок
 * 3) Для квадратов нечетно-четного порядка - метод четырех квадратов
 * В данном решении не используется декомпозиция, поэтому часть кода дублируется
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений
 *
 */
public class Task_16 {
    public static void main(String[] args) {
        // Считаем n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input dimension of the square n: ");
        int n = in.nextInt();
        in.close();

        // Если введено неверное n, сообщим об этом
        if (n < 3) {
            System.out.println("Input the correct n!");
            return;
        }

        // Создаем пустой массив
        int[][] a = new int[n][n];

        // Если квадрат нечетного порядка:
        if (((n % 2) == 1)) {
            /*
            Используем Индийский метод:
            "Число 1 вписывается в середину верхней строки. Далее числа вписываются в естественном порядке по восходящей
            диагонали. Как только число выходит за пределы квадрата, сразу перенесём его в эквивалентную ячейку внутри
            квадрата. Дойдя до числа kn, то есть до числа кратного порядку квадрата, пишем следующее число снизу от
            только что записанного числа и снова записываем числа по восходящей диагонали."
             */
            a[0][n/2] = 1;
            int i = -1;
            int j = n/2 + 1;
            int k = 2;
                while (k <= (n*n)) {
                if (i < 0) {
                    if (j > n-1) {
                        i += 2;
                        j -= 1;
                    }
                    else {
                        i = n - 1;
                    }
                }
                else if (j > n-1) {
                    j = 0;
                }
                else if (a[i][j] > 0) {
                    i += 2;
                    j -= 1;
                }
                else {
                    a[i][j] = k;
                    k++;
                    i--;
                    j++;
                }
            }
        }

        // Если квадрат четно-четный:
        else if (n % 4 == 0) {
            /*
            Используем метод квадратных рамок:
            */
            int k = 1;
            int i = 0;
            int j = 0;
            while (k <= n*n) {
                // Квадрат по часовой стрелке
                a[i][j] = k;
                k++;
                // Вверх и вправо
                for (int m = 0; m < n / 2 - 1; m++) {
                    i--;
                    j++;
                    if (i < 0) {
                        i = n - 1;
                    }
                    a[i][j] = k;
                    k++;
                }
                //переход вправо
                j++;
                a[i][j] = k;
                k++;
                // Вниз и вправо
                for (int m = 0; m < n / 2 - 1; m++) {
                    i++;
                    j++;
                    if (i > n - 1) {
                        i = 0;
                    }
                    a[i][j] = k;
                    k++;
                }
                //переход вниз
                i++;
                a[i][j] = k;
                k++;
                // Вниз и влево
                for (int m = 0; m < n / 2 - 1; m++) {
                    i++;
                    j--;
                    if (i > n - 1) {
                        i = 0;
                    }
                    a[i][j] = k;
                    k++;
                }
                // Переход влево
                j--;
                a[i][j] = k;
                k++;
                // Вверх и влево
                for (int m = 0; m < n / 2 - 1; m++) {
                    i--;
                    j--;
                    if (i < 0) {
                        i = n - 1;
                    }
                    a[i][j] = k;
                    k++;
                }

                // Переход на новый квадрат
                i++;
                j = n-1;

                // Квадрат против часовой стрелки
                a[i][j] = k;
                k++;
                // Вверх и влево
                for (int m = 0; m < n / 2 - 1; m++) {
                    i--;
                    j--;
                    if (i < 0) {
                        i = n - 1;
                    }
                    a[i][j] = k;
                    k++;
                }
                // Переход влево
                j--;
                a[i][j] = k;
                k++;
                // Вниз и влево
                for (int m = 0; m < n / 2 - 1; m++) {
                    i++;
                    j--;
                    if (i > n - 1) {
                        i = 0;
                    }
                    a[i][j] = k;
                    k++;
                }
                // Переход вниз
                i++;
                a[i][j] = k;
                k++;
                // Вниз и вправо
                for (int m = 0; m < n / 2 - 1; m++) {
                    i++;
                    j++;
                    if (i > n - 1) {
                        i = 0;
                    }
                    a[i][j] = k;
                    k++;
                }
                // Переход вправо
                j++;
                a[i][j] = k;
                k++;
                // Вверх и вправо
                for (int m = 0; m < n / 2 - 1; m++) {
                    i--;
                    j++;
                    if (i < 0) {
                        i = n - 1;
                    }
                    a[i][j] = k;
                    k++;
                }
                // Переход на новый квадрат
                i++;
                j = 0;
            }
        }

        // Если квадрат нечетно-четный, при этом n!=2:
        else  {
            /*
            Используем метод четырех квадратов. При этом для построения нечетных квадратов используем индийский метод.
            */
            // Сохраним значение n
            int saved_n = n;
            // Разобьем n пополам для того, чтобы получить 4 нечетных квадрата
            n = n/2;
            // Построим верхний левый квадрат
            a[0][n/2] = 1;
            int i = -1;
            int j = n/2 + 1;
            int k = 2;
            while (k <= (n*n)) {
                if (i < 0) {
                    if (j > n-1) {
                        i += 2;
                        j -= 1;
                    }
                    else {
                        i = n - 1;
                    }
                }
                else if (j > n-1) {
                    j = 0;
                }
                else if (a[i][j] > 0) {
                    i += 2;
                    j -= 1;
                }
                else {
                    a[i][j] = k;
                    k++;
                    i--;
                    j++;
                }
            }
            // Построим правый нижний квадрат
            a[n][n/2 + n] = k;
            i = -1 + n;
            j = (n/2 + 1) + n;
            k++;
            while (k <= n * n * 2) {
                if (i < n) {
                    if (j > n + (n-1)) {
                        i += 2;
                        j -= 1;
                    }
                    else {
                        i = n + n - 1;
                    }
                }
                else if (j > n + (n-1)) {
                    j = n;
                }
                else if (a[i][j] > 0) {
                    i += 2;
                    j -= 1;
                }
                else {
                    a[i][j] = k;
                    k++;
                    i--;
                    j++;
                }
            }
            // Построим правый верхний квадрат
            a[0][n/2 + n] = k;
            i = -1;
            j = (n/2 + 1) + n;
            k++;
            while (k <= n * n * 3) {
                if (i < 0) {
                    if (j > n + (n-1)) {
                        i += 2;
                        j -= 1;
                    }
                    else {
                        i = n - 1;
                    }
                }
                else if (j > n + (n-1)) {
                    j = n;
                }
                else if (a[i][j] > 0) {
                    i += 2;
                    j -= 1;
                }
                else {
                    a[i][j] = k;
                    k++;
                    i--;
                    j++;
                }
            }

            // Построим левый нижний квадрат
            a[n][n/2] = k;
            i = -1 + n;
            j = n/2 + 1;
            k++;
            while (k <= n * n * 4) {
                if (i < n) {
                    if (j > (n-1)) {
                        i += 2;
                        j -= 1;
                    }
                    else {
                        i = n + n - 1;
                    }
                }
                else if (j > n-1) {
                    j = 0;
                }
                else if (a[i][j] > 0) {
                    i += 2;
                    j -= 1;
                }
                else {
                    a[i][j] = k;
                    k++;
                    i--;
                    j++;
                }
            }
            // Вернем значение n
            n = saved_n;

            // Выведем квадрат на экран
            System.out.println("Matrix:");
            for (i = 0; i < n; i++) {
                System.out.println(Arrays.toString(a[i]));
            }
            System.out.println();
            // На данном этапе мы получили полностью заполненный квадрат. Теперь нужно поменять значения по алгоритму.
            int temp;
            // Поменяем значения в начале квадрата
            temp = a[0][0];
            a[0][0] = a[n/2][0];
            a[n/2][0] = temp;

            for (i = 1; i < ((n/2) - 1); i++) {
                temp = a[i][1];
                a[i][1] = a[n/2+i][1];
                a[n/2+i][1] = temp;
            }

            temp = a[(n/2)-1][0];
            a[(n/2)-1][0] = a[n-1][0];
            a[n-1][0] = temp;

            // Поменяем столбцы в середине квадрата
            int columns_count = n/2 - 3;
            for (j = (n/2) - (columns_count / 2); j < (n/2) + (columns_count / 2); j++) {
                for (i = 0; i < n/2; i++) {
                    temp = a[i][j];
                    a[i][j] = a[n/2+i][j];
                    a[n/2+i][j] = temp;
                }
            }
        }


        // Выведем квадрат на экран
        System.out.println("Magic square:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();

        // Проверим, действительно ли квадрат магический
        boolean is_magic = true;
        // Найдем магическую константу
        int magic_const = (n*(n*n+1))/2;
        //System.out.println("Magic_const = " + magic_const);
        // Цикл проверки
        int sum_d1 = 0;
        int sum_d2 = 0;
        for (int i = 0; i < n; i++) {
            int sum_i = 0;
            int sum_j = 0;
            for (int j = 0; j < n; j++) {
                sum_i += a[i][j];
                sum_j += a[j][i];
                if (i == j) {
                    sum_d1 += a[i][j];
                }
                if (i == n-j-1) {
                    sum_d2 += a[i][j];
                }
            }
            if ((sum_i != magic_const) || (sum_j != magic_const)) {
                is_magic = false;
                break;
            }
            System.out.println("i = " + i + "  sum = " + sum_i);
            System.out.println("j = " + i + "  sum = " + sum_j);
        }
        if ((sum_d1 != magic_const) || (sum_d2 != magic_const)) {
            is_magic = false;
        }
        //System.out.println("Диагональная сумма 1 = " + sum_d1);
        //System.out.println("Диагональная сумма 2 = " + sum_d2);

        // Проверяем логическую переменную
        if (is_magic) {
            System.out.println("Magic square check passed!");
        }
        else {
            System.out.println("ALARM! Code has bugs, Magic square check failed!!!");
        }
    }
}
