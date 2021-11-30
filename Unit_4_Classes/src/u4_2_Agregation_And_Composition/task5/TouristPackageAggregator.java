package u4_2_Agregation_And_Composition.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Класс, описывающий список туристических путевок, а так же реализующий алгоритмы сортировки и поиска путевок в списке.
 */
public class TouristPackageAggregator {
    private List<TouristPackage> packages = new ArrayList<>();

    // Конструктор с переменным количеством параметров, заполняющий список packages
    public TouristPackageAggregator (TouristPackage ... touristPackages) {
        for (TouristPackage touristPackage : touristPackages) {
            packages.add(touristPackage);
        }
    }

    // Конструктор, принимающий список объектов touristPackage, заполняющий список packages
    public TouristPackageAggregator(List<TouristPackage> touristPackages) {
        for (TouristPackage touristPackage : touristPackages) {
            packages.add(touristPackage);
        }
    }

    // Добавление путевки в массив
    public void addPackage (TouristPackage touristPackage) {
        packages.add(touristPackage);
    }

    // Поиск путевки по id. Возвращает null, если путевка не найдена
    public TouristPackage searchByID(int id) {
        for (TouristPackage touristPackage : packages) {
            if (touristPackage.getId() == id) {
                return touristPackage;
            }
        }
        return null;
    }

    // Поиск путевок по типу. Возвращает null, если путевки не найдены, или список путевок данного типа
    public List<TouristPackage> searchByType (String str) {
        List<TouristPackage> res = new ArrayList<>();
        TouristPackage.Type[] types = TouristPackage.Type.values();
        for (TouristPackage touristPackage : packages) {
            if (str.toUpperCase(Locale.ROOT).equals(touristPackage.getType().toString())) {
                    res.add(touristPackage);
            }
        }
        return res;
    }

    // Поиск путевок по типу. Возвращает null, если путевки не найдены, или список путевок данного типа
    public List<TouristPackage> searchByTransport (String str) {
        List<TouristPackage> res = new ArrayList<>();
        TouristPackage.Transport[] transports = TouristPackage.Transport.values();
        for (TouristPackage touristPackage : packages) {
            if (str.toUpperCase(Locale.ROOT).equals(touristPackage.getTransport().toString())) {
                res.add(touristPackage);
            }
        }
        return res;
    }

    // Поиск путевок по типу. Возвращает null, если путевки не найдены, или список путевок данного типа
    public List<TouristPackage> searchByMeals (String str) {
        List<TouristPackage> res = new ArrayList<>();
        TouristPackage.Meals[] meals = TouristPackage.Meals.values();
        for (TouristPackage touristPackage : packages) {
            if (str.toUpperCase(Locale.ROOT).equals(touristPackage.getMeals().toString())) {
                res.add(touristPackage);
            }
        }
        return res;
    }

    // Поиск путевок по количеству дней в диапазоне от минимального к максимальному
    public List<TouristPackage> searchByDays (int min, int max) {
        List<TouristPackage> res = new ArrayList<>();
        for (TouristPackage touristPackage : packages) {
            if ((touristPackage.getNumberOfDays() >= min) && (touristPackage.getNumberOfDays() <= max) ) {
                res.add(touristPackage);
            }
        }
        return res;
    }
    // Геттер всего списка
    public List<TouristPackage> getPackages() {
        return packages;
    }

    // Геттер конкретного элемента
    public TouristPackage getPackageByID(int id) {
        return searchByID(id);
    }

    // Заменяет текущий список путевок произвольным списком TouristPackage
    public void moveToAggregator (List<TouristPackage> touristPackages) {
        packages = touristPackages;
    }

    // Удаление путевки по id.
    public void deletePackageById(int id) {
        if (searchByID(id) == null) {
            packages.remove(searchByID(id));
        }
    }

    // Сортировки
    // Сортировка по ID
    public List<TouristPackage> sortById () {
        List<TouristPackage> rez = new ArrayList<>(packages);
        TouristPackage tmp;
        for (int i = 0; i < rez.size() - 1; i++) {
            while(rez.get(i).getId() > rez.get(i+1).getId()) {
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

    //Сортировка по цене
    public List<TouristPackage> sortByPrice () {
        List<TouristPackage> rez = new ArrayList<>(packages);
        TouristPackage tmp;
        for (int i = 0; i < rez.size() - 1; i++) {
            while(rez.get(i).getPrice() > rez.get(i+1).getPrice()) {
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

    // Приведение списка типа List<TouristPackage> к String
    public String toStr (List<TouristPackage> touristPackages) {
        StringBuilder rez = new StringBuilder();
        for (TouristPackage touristPackage : touristPackages) {
            rez.append(touristPackage.toString()).append("\n");
        }
        return rez.toString();
    }

    @Override
    public String toString() {
        StringBuilder rez = new StringBuilder();
        for (TouristPackage touristPackage : packages) {
            rez.append(touristPackage.toString()).append("\n");
        }
        return rez.toString();
    }
}
