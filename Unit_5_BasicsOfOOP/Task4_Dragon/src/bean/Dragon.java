package bean;

import dao.DragonDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий "Дракона". Хранит сокровища в своей пещере.
 * Взаимодействует с пользователем, и включает в себя логику просмотра сокровищ, выбора самого дорогого сокровища и
 * выбора сокровищ на заданную сумму.
 */
public class Dragon {
    private List<Treasure> dragon;
    DragonDAO dragonDAO;

    // Конструктор
    public Dragon() {
        dragonDAO = new DragonDAO();
        this.dragon = dragonDAO.getTreasures();
    }

    // Возвращает самое дорогое сокровище
    public Treasure getMostExpensive() {
        Treasure rez = dragon.get(0);
        for (int i = 1; i < dragon.size() - 1; i++) {
            if (rez.getCost() <= dragon.get(i).getCost()) {
                rez = dragon.get(i);
            }
        }
        return rez;
    }

    // Обновление списка "сокровищ", обновляет и исходный файл Dragon.txt
    public void refresh() {
        dragon = dragonDAO.refresh();
    }


    //Сортировка по цене, возвращает List<Treasure>, НЕ МЕНЯЕТ исходный список dragon
    public List<Treasure> sortByPrice() {
        List<Treasure> rez = new ArrayList<>(dragon);
        Treasure tmp;
        for (int i = 0; i < rez.size() - 1; i++) {
            while(rez.get(i).getCost() < rez.get(i+1).getCost()) {
                // Сохраняем объект bankAccount в переменную tmp
                tmp = rez.get(i);
                rez.remove(i);
                rez.add(i+1, tmp);
                if (i > 0) {
                    i--;
                }
            }
        }
        return rez;
    }
    /*
    Выбор сокровищ на заданную сумму. Выбирает из самых дорогих сокровищ, пока не останется слишком мало золота
     */
    public List<Treasure> buyTreasures(int gold) {
        // Отсортируем сокровища по цене
        List<Treasure> curList = this.sortByPrice();
        // Объявим результирующие переменные
        List<Treasure> rez = new ArrayList<>();
        int curGold = gold;
        // Пройдем по списку отсортированных сокровищ, и, если его можно купить, добавим в результирующий список
        for (int i = 0; i < curList.size(); i++) {
            if (curGold >= curList.get(i).getCost()) {
                rez.add(curList.get(i));
                curGold -= curList.get(i).getCost();
            }
        }
        // Добавим остаток золота как "сокровище" в конец списка
        rez.add(new Treasure("surplus gold after purchases", curGold));
        return rez;
    }

    /*
    Выбор сокровищ на заданную сумму, возвращает строку.
    Последний элемент - остаток, выведем его в отдельную строку
    Если сумма слишком маленькая, то напишем об этом
     */
    public String BoughtTreasuresToString (int gold) {
        List<Treasure> bought = this.buyTreasures(gold);
        StringBuilder rez = new StringBuilder();
        if (bought.size() == 1) {
            rez.append("The amount is less than the cost of any treasure!");
        }
        else {
            rez.append("Selected treasures for a given amount:").append(System.lineSeparator());
            for (int i = 0; i < bought.size() - 1; i++) {
                rez.append(bought.get(i).toString()).append(System.lineSeparator());
            }
            rez.append("The remainder is ").append(bought.get(bought.size() - 1).getCost()).append(" gold.");
        }
        return rez.toString();
    }

    //toString
    @Override
    public String toString() {
        StringBuilder rez = new StringBuilder();
        for (Treasure treasure : dragon) {
            rez.append(treasure.toString()).append(System.lineSeparator());
        }
        return rez.toString();
    }
}
