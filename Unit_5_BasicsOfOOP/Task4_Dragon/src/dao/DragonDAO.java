package dao;

import bean.Treasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, включающий в себя логику хранения и изменения данных о сокровищах в пещере дракона (класса Dragon).
 */
public class DragonDAO {
    private List<String> dragonStr;
    private final int NUMBER = 100;
    Generator generator;
    FileChanger dragonFile;

    public DragonDAO() {
        dragonFile = new FileChanger("data", "Dragon.txt");
        generator = new Generator();
        if (dragonFile.getContent().isEmpty()) {
            dragonStr = generator.generate(NUMBER);
            dragonFile.refresh(dragonStr);
        }
        else {
            dragonStr = dragonFile.getContent();
        }
    }

    public List<Treasure> refresh() {
        dragonStr = generator.generate(NUMBER);
        dragonFile.refresh(dragonStr);
        return getTreasures();
    }

    public List<Treasure> getTreasures() {
        List<Treasure> rez = new ArrayList<>();
        for (String line : dragonStr) {
            String[] tmp = line.split(";");
            if (tmp.length > 1) {
                rez.add(new Treasure(tmp[0], Integer.parseInt(tmp[1])));
            }
            else {
                rez.add(new Treasure((tmp[0])));
            }
        }
        return rez;
    }
}
