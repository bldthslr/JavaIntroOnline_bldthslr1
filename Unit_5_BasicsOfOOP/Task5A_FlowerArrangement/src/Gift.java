import java.util.*;

/**
 * Класс, описывающий подарок.
 * Подарок состоит из сладостей, и упаковки
 */
public class Gift {
    private Packaging packaging;
    private List<Candy> candyList = new ArrayList<>();

    // Перегруженные конструкторы
    // Конструктор с переменным числом параметров
    public Gift(Packaging packaging, Candy... candies) {
        this.packaging = packaging;
        Collections.addAll(candyList, candies);
    }
    // Конструктор со списком
    public Gift(Packaging packaging, List<Candy> candies) {
        this.packaging = packaging;
        this.candyList.addAll(candies);
    }
    // Конструктор без параметров
    public Gift() {
        this.packaging = null;
    }

    // Геттеры
    public Packaging getPackaging() {
        return packaging;
    }

    public List<Candy> getCandyList() {
        return candyList;
    }

    // Сеттеры
    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public void setCandyList(List<Candy> candyList) {
        this.candyList = candyList;
    }

    /*
    Подсчитаем количество уникальных сладостей у нас в подарке
    Для этого создадим Словарь (HashMap), где в качестве ключа будет выступать объект Candy, а в качестве значения -
    количество вхождений.
    Т.к. методы hashCode() и equals() были переопределены, метод будет работать корректно
     */
    private Map<Candy, Integer> createCandyMap() {
        Map<Candy, Integer> map = new HashMap<>();
        for (Candy candy : candyList) {
            if (map.get(candy) == null) {
                map.put(candy, 1);
            }
            else {
                map.put(candy, map.get(candy) + 1);
            }
        }
        return map;
    }
    // Переопределим toString. Для подсчета одинаковых конфет воспользуемся методом CreateCandyMap()
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("____________________________________________________________").append(System.lineSeparator());
        res.append("A Gift in ").append(packaging).append("!").append(System.lineSeparator());
        res.append("Our gift includes:").append(System.lineSeparator());
        Map<Candy, Integer> map = createCandyMap();
        for (Candy candy : map.keySet()) {
            res.append(map.get(candy)).append(" ").append(candy).append(System.lineSeparator());
        }
        res.append("____________________________________________________________").append(System.lineSeparator());
        return res.toString();
    }
}
