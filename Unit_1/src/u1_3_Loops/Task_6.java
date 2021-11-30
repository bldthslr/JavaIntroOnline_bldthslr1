package u1_3_Loops;

import java.nio.charset.Charset;

/**
 * "6. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера".
 *
 * В данной реализации выведем символы из таблицы ASCII, т.е. тех, которые занимают 7 бит памяти
 * В Java используется кодировка UTF-8, однако первые символы кодировок ASCII и UTF-8 совпадают
 * Выведем код символа (в двоичном виде) и его соответствие в таблице ASCII
 */
public class Task_6 {
    public static void main(String[] args) {
        //System.out.println(Charset.defaultCharset());                                           //UTF-8
        for (int i = 0; i < 128; i++) {
            System.out.println(Integer.toBinaryString(i) + " = " + (char) i);
        }
    }
}
