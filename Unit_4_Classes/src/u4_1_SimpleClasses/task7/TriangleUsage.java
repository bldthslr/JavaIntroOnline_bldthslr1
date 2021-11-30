package u4_1_SimpleClasses.task7;

import java.util.Scanner;

/**
 * Использование клсаа "Triangle".
 * Для проверки использовались точки A(3, 1); B(6,5); C(9, -1).
 */
public class TriangleUsage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the x and y coordinates of the first point:");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        System.out.println("Input the x and y coordinates of the second point:");
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        System.out.println("Input the x and y coordinates of the third point:");
        double x3 = in.nextDouble();
        double y3 = in.nextDouble();
        Triangle triangle = new Triangle(x1,y1,x2,y2,x3,y3);
        if (!triangle.isTriangle()) {
            System.out.println("It is not possible to construct a triangle from the given points");
            System.out.println("Shutting down...");
            return;
        }
        System.out.println("The perimeter of the triangle:");
        System.out.println(triangle.getPerimeter());
        System.out.println("The area of the triangle:");
        System.out.println(triangle.getArea());
        System.out.println("Median intersection point:");
        System.out.println(triangle.getMedianPoint());
    }
}
