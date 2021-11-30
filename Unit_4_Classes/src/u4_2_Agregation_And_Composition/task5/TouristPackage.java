package u4_2_Agregation_And_Composition.task5;

/**
 * "5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
 * различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
 * возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. "
 *
 * Данный класс описывает одну туристическую путевку. Имеет следующие поля:
 * 1) Уникальный id номер;
 * 2) Тип путевки (Круиз, экскурсия, шоппинг, морской отдых, санаторий);
 * 3) Тип транспорта (Самолет, поезд, автобус, корабль, автомобиль);
 * 4) Тип питания (без питания, только завтраки, полное)
 * 5) Пункт назначения (строка)
 * 6) Цена (вещественное число)
 * 7) Количество полных дней (целое число)
 *
 * Для данного класса объявлен конструктор, геттеры и сеттеры, а так же переопределен метод toString.
 */
public class TouristPackage {
    public enum Type {
        CRUISE,
        EXCURSION,
        SHOPPING,
        SEATOUR,
        TREATMENT
    }
    public enum Transport {
        AIRPLANE,
        TRAIN,
        BUS,
        SHIP,
        CAR
    }
    public enum Meals {
        NO,
        BREAKFAST,
        FULL
    }
    static int id_count;
    private int id;
    private Type type;
    private Transport transport;
    private Meals meals;
    private String place;
    private double price;
    private int numberOfDays;

    public TouristPackage (Type type, Transport transport, Meals meals, String place, double price, int numberOfDays) {
        id_count++;
        this.id = id_count;
        this.type = type;
        this.transport = transport;
        this.meals = meals;
        this.place = place;
        this.price = price;
        this.numberOfDays = numberOfDays;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Transport getTransport() {
        return transport;
    }

    public Meals getMeals() {
        return meals;
    }

    public String getPlace() {
        return place;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    // Сеттеры
    public void setType(Type type) {
        this.type = type;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setMeals(Meals meals) {
        this.meals = meals;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
            return "Travel package №" + id +
                ": [type: " + type +
                ", transport:" + transport +
                ", meals: " + meals +
                ", place: " + place +
                ", price: " + price +
                ", numberOfDays: " + numberOfDays +
                ']';
    }
}
