import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * "Задача 3.
 * Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
 * выходных и праздничных днях."
 *
 * Класс MyCalendar, использующий внутренний класс Weekend для хранения информации о выходных и праздничных днях.
 * Единственное поле - список выходных (объектов Weekend).
 * В данном классе реализовано добавление, поиск, удаление выходного дня, а так же сортировка списка выходных;
 * переопределен метод toString(), а так же добавлен метод toStringWithSort, возвращающий отсортированный список в виде String.
 *
 * Метод addAllSatAndSun() добавляет в список выходных weekends ВСЕ субботы и воскресения в текущем году.
 */
public class MyCalendar {
    // Список выходных дней
    private List<Weekend> weekends;

    // "Пустой" Конструктор
    public MyCalendar() {
        weekends = new ArrayList<>();
    }


    /**
     * Внутренний класс Weekend, хранящий информацию о дате выходного (или праздничного) дне.
     * Поля:
     * date - дата праздника или выходного (объект типа LocalDate);
     * note - описание типа String.
     * В данном классе переопределен метод toString(), причем даты возвращаются в формате (DD:MM:YYYY).
     */
    private class Weekend {
        LocalDate date;
        String note;

        /*
        Конструкторы:
         */
        public Weekend(LocalDate date, String note) {
            this.date = date;
            this.note = note;
        }

        public Weekend(int day, int month, String note) {
            date = LocalDate.of(LocalDate.now().getYear(), month, day);
            this.note = note;
        }

        public Weekend(int day, int month, int year, String note) {
            date = LocalDate.of(year, month, day);
            this.note = note;
        }

        // Обновляет значения полей даты и описания
        public void setWeekend(Weekend weekend) {
            date = weekend.date;
            note = weekend.note;
        }

        // Добавляет 0 впереди чисел 1-9
        public String addZero(int num) {
            if ((num > 0) && (num < 10)) {
                return "0" + num;
            }
            else return String.valueOf(num);
        }

        // Переопределение метода toString()
        @Override
        public String toString() {
            String tmp;
            if (note.equals("")) {
                tmp = "<does not have a description!>";
            }
            else {
                tmp = note;
            }
            return addZero(date.getDayOfMonth()) + "." +
                    addZero(date.getMonthValue()) + "." +
                    addZero(date.getYear()) + " - " + tmp;
        }
    }


    /**
     * Методы класса MyCalendar
     */

    // Поиск выходного дня в списке выходных дней, в качестве параметра получает объект Weekend
    public Weekend searchInWeekends(Weekend weekend) {
        for (Weekend wknd : weekends) {
            if (weekend.date.equals(wknd.date)) {
                return wknd;
            }
        }
        return null;
    }

    //Проверяет, есть ли дата выходного в списке выходных дней, в качестве параметра день, месяц, год
    public Weekend searchInWeekends(int day, int month, int year) {
        for (Weekend wknd : weekends) {
            if ((wknd.date.getDayOfMonth() == day) && (wknd.date.getMonthValue() == month) && (wknd.date.getYear() == year)) {
                return wknd;
            }
        }
        return null;
    }

    //Проверяет, есть ли дата выходного в списке выходных дней, в качестве параметра день, месяц, год - текущий год
    public Weekend searchInWeekends(int day, int month) {
        return searchInWeekends(day, month, LocalDate.now().getYear());
    }

    // Добавляет выходной в список выходных, если он уже есть - обновляет его описание
    public int addWeekend(Weekend weekend) {
        Weekend tmp = searchInWeekends(weekend);
        if (tmp != null) {
            if (!weekend.note.equals("")) {
                tmp.note = tmp.note + " | " + weekend.note;
            }
            return 0;
        }
        else {
            try {
                weekends.add(weekend);
                return 0;
            } catch (Exception e) {
                return -1;
            }
        }
    }
    // Добавляет выходной в список выходных, если он уже есть - обновляет его описание
    public int addWeekend(int day, int month, int year, String note) {
        Weekend tmp = searchInWeekends(day, month, year);
        if (tmp != null) {
            if (!note.equals("")) {
                tmp.note = tmp.note + " | " + note;
            }
            return 0;
        }
        else {
            try {
                weekends.add(new Weekend(day, month, year, note));
                return 0;
            } catch (Exception e) {
                return -1;
            }
        }
    }

    public int addWeekend(int day, int month, int year) {
        return addWeekend(day, month, year, "");
    }

    public int addWeekend(int day, int month, String note) {
        Weekend tmp = searchInWeekends(day, month);
        if (tmp != null) {
            if (!note.equals("")) {
                tmp.note = tmp.note + " | " + note;
            }
            return 0;
        }
        else {
            try {
                weekends.add(new Weekend(day, month, note));
                return 0;
            } catch (Exception e) {
                return -1;
            }
        }
    }

    public int addWeekend(int day, int month) {
        return addWeekend(day, month, "");
    }

    // Удаление выходного дня из списка;
    // Возвращает 0 при успешном удалении, возвращает 1, если выходной день не найден
    public int deleteWeekend(int day, int month, int year) {
        Weekend tmp = (searchInWeekends(day, month, year));
        if (tmp == null) {
            return 1;
        }
        else {
            weekends.remove(tmp);
            return 0;
        }
    }

    // Удаление выходного дня, учитывающие текущий год
    public int deleteWeekend(int day, int month) {
        return deleteWeekend(day, month, LocalDate.now().getYear());
    }

    // Добавление всех суббот и воскресений в текущем году в качестве выходных
    public int addAllSatAndSun() {
        try {
            Weekend cur = new Weekend(1,1,"");
            while (cur.date.getYear() == LocalDate.now().getYear()) {
                if (cur.date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    cur.note = "SATURDAY";
                    addWeekend(cur);
                }
                if (cur.date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    cur.note = "SUNDAY";
                    addWeekend(cur);
                }
                cur = new Weekend(cur.date.plusDays(1), "");
            }
            return 0;
        }
        catch (Exception e) {
            return -1;
        }
    }

    // Сортировка списка выходных, возвращающая новый отсортированный список
    public List<Weekend> sortList() {
        List<Weekend> weekendsCopy = List.copyOf(weekends);
        Weekend temp;
        for (int i = 0; i < weekendsCopy.size()-1; i++) {
            while (weekendsCopy.get(i).date.isAfter(weekendsCopy.get(i+1).date)) {
                temp = new Weekend(weekendsCopy.get(i).date, weekendsCopy.get(i).note);
                weekendsCopy.get(i).setWeekend( weekendsCopy.get(i+1));
                weekendsCopy.get(i+1).setWeekend(temp);
                if (i > 0) {
                    i--;
                }
            }
        }
        return weekendsCopy;
    }

    // Строковое представление отсортированного списка выходных
    public String toStringWithSort() {
        // Отсортируем список выходных и праздников по датам, от убывающих к возрастающим
        List<Weekend> sorted = sortList();
        StringBuilder rez = new StringBuilder();
        for (Weekend weekend : sorted) {
            rez.append(weekend.toString()).append("\n");
        }
        return rez.toString();
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        StringBuilder rez = new StringBuilder();
        for (Weekend weekend : weekends) {
            rez.append(weekend.toString()).append("\n");
        }
        return rez.toString();
    }
}

