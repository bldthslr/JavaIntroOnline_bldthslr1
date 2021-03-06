package u1_3_Loops;

import java.util.Scanner;

/**
 * 7. "Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
 * m и n вводятся с клавиатуры."
 *
 * Для данного решения используем вложенный цикл
 * Во внешнем цикле будем проходить по промежутку, а во внутреннем - находить делители и выводить их на экран
 * В данном решении не реализуются проверки на попадание в бесконечный циккл, а так же обработка исключений
 */
public class Task_7 {
    public static void main(String[] args) {
        //считываем m и n из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input m: ");
        int m = in.nextInt();
        System.out.print("Input n: ");
        int n = in.nextInt();
        in.close();
        int count;  // число делителей, нужно для правильного формирования вывода
        // внешний цикл, проходим от m до n
        for (int i = m; i < n+1; i++) {
            count = 0; // для нового числа обнуляем количество делителей
            System.out.print("Делители числа " + i + ": ");
            // внутренний цикл, ищем делители от двух до нужного числа - 1
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    if (count == 0) {
                        System.out.print(j);            // если вхождение первое, выводим делитель на экран
                    }
                    else {
                        System.out.print(", " + j);     // если вхождение не первое, добавляем запятую и пробел
                    }
                    count += 1;
                }
            }
            // возвращаемся во внешний цикл
            if (count == 0) {
                System.out.println("число простое.");   // если делителей не было найдено, выведем "простое число."
            }
            else {
                System.out.println(".");               // если делители были найдены, добавим точку в конце вывода
            }
        }
    }
}
