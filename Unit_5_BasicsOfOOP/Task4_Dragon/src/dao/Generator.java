package dao;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private List<Item> itemList;
    private List<Modifier> weaponMods;
    private List<Modifier> jewerlyMods;

    /**
     * Класс Generator - генерирует список сокровищ. Подробнее о работе генераторе в файле README.md
     */

    /*
    Конструктор. Открывает файлы types.txt, weapon_rarity.txt и jewerly_rarity.txt, парсит их, и заполняет списки
    itemList, weaponMods, jewerlyMods.
     */
    public Generator() {
        // Создаем список всех предметов
        itemList = new ArrayList<>();
        // Создаем список модификаций
        weaponMods = new ArrayList<>();
        jewerlyMods = new ArrayList<>();
        // Заполняем список itemList из файла types.txt
        List<String> itemStr = new FileChanger("data","types.txt").getContent();
        int i = 0;
        String curType;
        double curTypeChance;
        while (i < itemStr.size() - 1) {
            curType = itemStr.get(i).split(";")[0];
            curTypeChance = Double.parseDouble(itemStr.get(i).split(";")[1]);
            i++;
            if (itemStr.get(i).equals("<")) {
                i++;
                while (!itemStr.get(i).equals(">")) {
                    // Массив строк из начальной строки
                    String[] curItemSplit = itemStr.get(i).split(";");
                    String name = curItemSplit[0];
                    int cost = Integer.parseInt(curItemSplit[1]);
                    // Общий шанс - шанс предмета * шанс типа предмета
                    double rawRarity = Double.parseDouble(curItemSplit[2]) * curTypeChance;
                    // Добавляем предмет в общий список
                    itemList.add(new Item(name, cost, curType, rawRarity));
                    i++;
                }
                i++;
            }
        }
        // Заполняем список модификаторов modifiers
        List<String> curModList;
        String curStrArr[];
        // Добавим модификаторы оружия
        curModList = new FileChanger("data", "weapon_rarity.txt").getContent();
        for (String str : curModList) {
            if (!str.equals("")) {
                curStrArr = str.split(";");
                boolean prefix = curStrArr[0].equals("-");
                String addName = curStrArr[1];
                double costMultiplier = Double.parseDouble(curStrArr[2]);
                double rawRarity = Double.parseDouble(curStrArr[3]);
                weaponMods.add(new Modifier(prefix, addName, costMultiplier, rawRarity));
            }
        }
        // Добавим модификаторы "драгоценностей"
        curModList = new FileChanger("data", "jewerly_rarity.txt").getContent();
        for (String str : curModList) {
            if (!str.equals("")) {
                curStrArr = str.split(";");
                boolean prefix = curStrArr[0].equals("-");
                String addName = curStrArr[1];
                double costMultiplier = Double.parseDouble(curStrArr[2]);
                double rawRarity = Double.parseDouble(curStrArr[3]);
                jewerlyMods.add(new Modifier(prefix, addName, costMultiplier, rawRarity));
            }
        }
    }

    /**
     * Внутренний класс предметов (сокровищ)
     */
    private static class Item {
        private String name;
        private int cost;
        private String type;
        private double rawRarity;
        private double rarity;

        public Item(String name, int cost, String type, double rawRarity) {
            this.name = name;
            this.cost = cost;
            this.type = type;
            this.rawRarity = rawRarity;
        }
    }

    /**
     * Внутренний класс модификаторов для сокровищ.
     */
    private static class Modifier {
        boolean prefix;
        String addName;
        double costMultiplier;
        double rawRarity;
        double rarity;

        // Генератор
        public Modifier(boolean prefix, String addName, double costMultiplier, double rawRarity) {
            this.prefix = prefix;
            this.addName = addName;
            this.costMultiplier = costMultiplier;
            this.rawRarity = rawRarity;
        }
    }


    // Подсчитаем вероятность для каждого предмета
    private void calculateItemsRarity() {
        double sum = 0.0;
        for (Item item : itemList) {
            sum += item.rawRarity;
        }
        double curSum = 0.0;
        for (Item item : itemList) {
            curSum += item.rawRarity / sum;
            item.rarity = curSum;
        }
    }
    // Подсчитаем вероятность для модификаторов оружия
    private void calculateWeaponModsRarity() {
        double sum = 0.0;
        for (Modifier mod : weaponMods) {
            sum += mod.rawRarity;
        }
        double curSum = 0.0;
        for (Modifier mod : weaponMods) {
            curSum += mod.rawRarity / sum;
            mod.rarity = curSum;
        }
    }

    // Подсчитаем вероятность для драгоценностей
    private void calculateJewerlyModsRarity() {
        double sum = 0.0;
        for (Modifier mod : jewerlyMods) {
            sum += mod.rawRarity;
        }
        double curSum = 0.0;
        for (Modifier mod : jewerlyMods) {
            curSum += mod.rawRarity / sum;
            mod.rarity = curSum;
        }
    }

    /*
    Основной метод генерации сокровищ. Возвращает список сокровищ в строковом виде. number - количество элементов в
    результирующем List
     */
    public List<String> generate(int number) {
        List<String> rez = new ArrayList<>();
        calculateItemsRarity();
        calculateWeaponModsRarity();
        calculateJewerlyModsRarity();
        for (int i = 0; i < number; i++) {
            rez.add(generateTreasureStr());
        }
        return rez;
    }

    /*
    Генерирует строку с сокровищами, используя поле rarity внутренних классов.
     */
    private String generateTreasureStr() {
        String name;
        int cost;
        double rand;
        // Выберем случайный предмет (сокровище);
        rand = Math.random();
        int i = 0;
        while (itemList.get(i).rarity < rand) {
            i++;
        }
        name = itemList.get(i).name;
        cost = itemList.get(i).cost;
        // Выбираем случайный модификатор
        if (itemList.get(i).type.equals("weapon")) {
            i = 0;
            while (weaponMods.get(i).rarity < rand) {
                i++;
            }
            if (weaponMods.get(i).prefix) {
                if (!weaponMods.get(i).addName.equals("")) {
                    name = weaponMods.get(i).addName + " " + name;
                }
            }
            else {
                if (!weaponMods.get(i).addName.equals("")) {
                    name = name + " " + weaponMods.get(i).addName;
                }
            }
            cost *= weaponMods.get(i).costMultiplier;
        }
        if (itemList.get(i).type.equals("jewerly")) {
            i = 0;
            rand = Math.random();
            while (jewerlyMods.get(i).rarity < rand) {
                i++;
            }
            if (jewerlyMods.get(i).prefix) {
                if (!jewerlyMods.get(i).addName.equals("")) {
                    name = jewerlyMods.get(i).addName + " " + name;
                }
            }
            else {
                if (!jewerlyMods.get(i).addName.equals("")) {
                    name = name + " " + jewerlyMods.get(i).addName;
                }
            }
            cost *= jewerlyMods.get(i).costMultiplier;
        }
        return name + ";" + cost + ";";
    }
}
