package u4_1_SimpleClasses.task7;
/**
 * "7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
 * площади, периметра и точки пересечения медиан."
 *
 * Объект треугольника создается по трем точкам с координатами: A(x1,y1), B(x2,y2), C(x3,y3).
 * Для треугольника описаны геттеры и сеттеры.
 *
 * Код, демонстрирующий возможности класса предстваленн в классе "TriangleUsage".
 */
public class Triangle {
    // Создадим небольшой внутренний класс, который описывает точку на координатной плоскости.
    private class Dot {
        private double x;
        private double y;

        private Dot(double x,double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Инициализируем поля класса
    private Dot a, b, c;

    // Конструктор, принимающий координаты точек:
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        a = new Dot(x1, y1);
        b = new Dot(x2, y2);
        c = new Dot(x3, y3);

    }

    // Сеттеры
    public void setXinA(double x) {
        this.a.x = x;
    }

    public void setXinB(double x) {
        this.b.x = x;
    }

    public void setXinC(double x) {
        this.c.x = x;
    }

    public void setYinA(double y) {
        this.a.y = y;
    }

    public void setYinB(double y) {
        this.b.y = y;
    }

    public void setYinC(double y) {
        this.c.y = y;
    }

    public void setA(double x, double y) {
        this.a.x = x;
        this.a.y = y;
    }

    public void setB(double x, double y) {
        this.b.x = x;
        this.b.y = y;
    }

    public void setC(double x, double y) {
        this.c.x = x;
        this.c.y = y;
    }

    // геттеры
    public double getXinA() {
        return a.x;
    }

    public double getXinB() {
        return b.x;
    }

    public double getXinC() {
        return c.x;
    }

    public double getYinA() {
        return a.y;
    }

    public double getYinB() {
        return b.y;
    }

    public double getYinC() {
        return c.y;
    }


    // Метод для проверки существования треугольника. Он не существует, если его точки равны или лежат на одной прямой.
    public boolean isTriangle() {
        // Зададим необходимую точность для сравнения
        double eps = 0.000001;
        // Проверим на равенство х1 = х2 = х3 или y1 = y2 = y3 с использование Эпсилон
        if (((Math.abs(a.x - b.x) <= eps) && (Math.abs(b.x - c.x) <= eps)) ||
                ((Math.abs(a.y - b.y) <= eps) && (Math.abs(b.y - c.y) <= eps))) {
            return false;
        }
        /* (x - x1) / (x2 - x1) == (y - y1) / (y2 - y1)) - уравнение прямой, подставим в него 3ью точку
        и сравним модуль разности с Эпсилон */
        else {
            return !(Math.abs(((c.x - a.x) / (b.x - a.x)) - ((c.y - a.y) / (b.y - a.y))) <= eps);
        }
    }

    // Метод вычисления длинны отрезка по двум точкам
    public double segLength (double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2 - y1), 2));
    }

    // Методы для вычисления длинны сторон
    public double getSideAB() {
        return segLength(a.x, b.x, a.y, b.y);
    }

    public double getSideBC() {
        return segLength(b.x, c.x, b.y, c.y);
    }

    public double getSideAC() {
        return segLength(a.x, c.x, a.y, c.y);
    }

    // Периметр
    public double getPerimeter() {
        return getSideAB() + getSideAC() + getSideBC();
    }

    // Площадь
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p*(p-getSideAB())*(p-getSideBC())*(p-getSideAC()));
    }

    // Точка пересечения медиан
    // Для нахождения точки пересечения медиан разобъем сторону AC пополам точкой K, проведем медиану BK и найдем точку O
    // Для реализации метода используем формулу деления отрезка в данном отношении
    public String getMedianPoint() {
        double kx = (a.x + c.x) / 2;
        double ky = (a.y + c.y) / 2;
        double ox = (b.x + kx * 2) / 3;
        double oy = (b.y + ky * 2) / 3;
        ox = ((double) ((int) (ox * 1000))) / 1000;
        oy = ((double) ((int) (oy * 1000))) / 1000;
        return "x = " + ox + "; y = " + oy;
    }

}

