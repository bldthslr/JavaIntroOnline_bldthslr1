package bean;

/**
 * Класс, описывающий сокровище. Имеет поля "название" и "стоимость". Содержит конструктор, геттеры и сеттеры, а так же
 * переопределен метод toString().
 */
public class Treasure {
    private String name;
    private int cost;

    public Treasure(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Treasure(String name) {
        this.name = name;
        this.cost = 0;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }


    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    // toString+
    @Override
    public String toString(){
        StringBuffer rez = new StringBuffer();
        rez.append(name);
        for (int i = rez.length(); i < 50; i++) {
            rez.append(' ');
        }
        rez.append(" (").append(cost).append(')');
        return rez.toString();
    }
}
