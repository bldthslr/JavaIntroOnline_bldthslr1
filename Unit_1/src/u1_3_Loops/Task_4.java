package u1_3_Loops;

import java.math.BigInteger;

/**
 * "4. "Составить программу нахождения произведения квадратов первых двухсот чисел"
 *
 * В данном решении ответ довольно быстро уйдет за диапазоны int, поэтому используется класс BigInteger
 */
public class Task_4 {
    public static void main(String[] args) {
        BigInteger p = BigInteger.ONE;
        for (int i = 0; i < 20000; i++) {
            p = p.multiply(BigInteger.valueOf((i + 1) * (i + 1)));
            System.out.println(p + "\n");
        }
        System.out.println(p);
    }
}
