package u2_4_Decompositions;

import java.util.Scanner;

/**
 * "Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
 * если угол между сторонами длиной X и Y— прямой."
 *
 * Числа X, Y, Z, Т считываются из потока ввода.
 * Будем считать, что четырехугольник может быть только выпуклым, т.е. сумма его углов = 360 гр.
 * Тогда любой такой четырехугольник можно разбить на два треугольника со сторонами:
 * 1) X, Y, гипотенуза XY; 2) гипотенуза XY, Z, T
 * Искомой площадью будет сумма площадей двух этих треугольников
 * Реализуем методы для нахождения гипотенузы в прямоугольном треугольнике, нахождения площади тр-а по 3 сторонам,
 * и поиска площади четырехугольника по 4 сторонам с прямым углом между первыми двумя сторонами.
 * В данном решении реализована проверка на существование четырехугольника с прямым углом по заданным сторонам.
 * В данном решении не реализуются проверки на попадание в бесконечный цикл, а так же обработка исключений.
 */
public class Task_9 {
    public static void main(String[] args) {
        // Считаем X, Y, Z, Т из потока ввода
        Scanner in = new Scanner(System.in);
        System.out.print("Input first side x: ");
        double x = in.nextDouble();
        System.out.print("Input second side y: ");
        double y = in.nextDouble();
        System.out.print("Input third side z: ");
        double z = in.nextDouble();
        System.out.print("Input fourth side t: ");
        double t = in.nextDouble();
        in.close();
        // Выведем результат на экран
        System.out.println("The area of a quadrilateral with sides x = " + x + ", y = " + y + ", z = " + z +
                ", t = " + t + ":");
        System.out.println(quadrilateralSquareWithRightAngle(x,y,z,t));
    }

    /**
     * Метод возвращает длину гипотенузы прямоугольного треугольника с катетами a, b.
     * @param a - длинна первой стороны
     * @param b - длинна второй стороны
     * @return - длинна гипотенузы
     */
    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    /**
     * Метод возвращает площадь треугольника с длинами сторон a, b, c.
     * @param a - длинна первой стороны
     * @param b - длинна второй стороны
     * @param c - длинна третьей стороны
     * @return - площадь треугольника
     */
    public static double triangleSquareBySides (double a, double b, double c) {
        // вычислим полупериметр треугольника
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Метод возвращает площадь выпуклого четырехугольника со сторонами x, y, z, t и прямым углом между сторонами x и y.
     * Проверки на существование такого четырехугольника не проводятся.
     * @param x - первая сторона
     * @param y - вторая сторона
     * @param z - третья сторона
     * @param t - четвертая сторона
     * @return - площадь четырехугольника
     */
    public static double quadrilateralSquareWithRightAngle(double x, double y, double z, double t) {
        return triangleSquareBySides(x, y, hypotenuse(x, y)) +
                triangleSquareBySides(hypotenuse(x,y),z,t);
    }
}