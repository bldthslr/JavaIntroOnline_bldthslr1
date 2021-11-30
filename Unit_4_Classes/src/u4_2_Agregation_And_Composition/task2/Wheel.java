package u4_2_Agregation_And_Composition.task2;
/**
 * Класс Wheel, использующийся в классе car.
 *
 * Поля:
 * brand - наименование бренда колеса;
 * name - наименование самого колеса;
 * type - тип дисков;
 * r - радиус;
 * h - высота профиля;
 * l - ширина шины.
 *
 * В конструкторе не проверяются значения параметров на валидонсть.
 * В данном классе переопределен метод toString.
 */
public class Wheel {
    private String name;
    private String brand;
    private int r, l, h;

    public Wheel(String name, String brand, int r, int l, int h) {
        this.name = name;
        this.brand = brand;
        this.r = r;
        this.l = l;
        this.h = h;
    }

    // Геттеры
    public String getName(){
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getR() {
        return r;
    }

    public int getL() {
        return l;
    }

    public int getH() {
        return h;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(brand).append(" ").append(name).append(" R");
        res.append(r).append(" ").append(l).append("/").append(h).append(".");
        return res.toString();
    }
}
