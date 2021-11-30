package u1_3_Loops;

/**
 * "3. "Найти сумму квадратов первых ста чисел."
 */

public class Task_3 {
    public static void main(String[] args) {
        int s = 0;
        for (int i = 0; i < 100; i++) {
            s += Math.pow(i+1, 2);
        }
        System.out.println(s);
        //решение без использования цикла, используя формулу суммы квадратов
        /*
        int n = 100;
        s = (n * (n + 1) * (2 * n + 1)) / 6;
        System.out.println(s);
         */
    }
}
