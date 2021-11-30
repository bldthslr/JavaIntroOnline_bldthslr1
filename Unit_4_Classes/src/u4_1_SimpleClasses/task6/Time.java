package u4_1_SimpleClasses.task6;

/**
 * 6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
 * недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
 * заданное количество часов, минут и секунд.
 *
 * Изменение времени на заданное количество часов производится следующим образом:
 * 1) Для часов - если количество часов больше 24, то добавляется только остаток от деления на 24. Пример:
 * "Добавить 25 часов == добавить 1 час"
 * Если результат добавления больше 24 часов (переполнение), то остается так же остаток от деления на 24. Пример:
 * "Было 20:00, добавили 10:00. Результат - 06:00.
 * 2) Для минут алгоритм аналогичен с добавлением часов, однако результат деления на 60 (количество часов) передается
 * в метод добавления часов. Пример:
 * "Было 12:00. Добавить 100 минут. Стало 13:40".
 * 3) Для секунд алгоритм аналогичен с добавлением минут, однако результат деления на 60 (количество минут) передается
 * в метод добавления минут. Пример:
 * "Было 13:40:00. Добавить 100 секунд. Стало 13:41:40".
 *
 * Код, демонстрирующий возможности класса предстваленн в классе "TimeUsage".
 */
public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    // Конструктор без параметров
    public Time(){
        seconds = 0;
        minutes = 0;
        hours = 0;
    }

    // Конструктор с параметрами
    public Time(int hours, int minutes, int seconds) {
        if ((seconds >= 0) && (seconds < 60)) {
            this.seconds = seconds;
        }
        else {
            System.out.println("invalid value for seconds! Changing value to 0.");
            this.seconds = 0;
        }
        if ((minutes >= 0) && (minutes < 60)) {
            this.minutes = minutes;
        }
        else {
            System.out.println("invalid value for minutes! Changing value to 0.");
            this.minutes = 0;
        }
        if ((hours >= 0) && (hours < 24)) {
            this.hours = hours;
        }
        else {
            System.out.println("invalid value for hours! Changing value to 0.");
            this.hours = 0;
        }
    }

    // Геттеры
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    // Возвращает время в виде строки в формате "HH:MM:SS"
    public String getTime() {
        String seconds, minutes, hours;
        if (this.seconds < 10) {
            seconds = "0" + this.seconds;
        }
        else {
            seconds = String.valueOf(this.seconds);
        }
        if (this.minutes < 10) {
            minutes = "0" + this.minutes;
        }
        else {
            minutes = String.valueOf(this.minutes);
        }
        if (this.hours < 10) {
            hours = "0" + this.hours;
        }
        else {
            hours = String.valueOf(this.hours);
        }
        return hours + ':' + minutes + '.' + seconds;
    }

    // Сеттеры с проверкой допустимых значений

    public void setSeconds(int seconds) {
        if ((seconds >= 0) && (seconds < 60)) {
            this.seconds = seconds;
        }
        else {
            System.out.println("invalid value for seconds! Changing value to 0.");
            this.seconds = 0;
        }
    }

    public void setMinutes(int minutes) {
        if ((minutes >= 0) && (minutes < 60)) {
            this.minutes = minutes;
        }
        else {
            System.out.println("invalid value for minutes! Changing value to 0.");
            this.minutes = 0;
        }
    }

    public void setHours(int hours) {
        if ((hours >= 0) && (hours < 24)) {
            this.hours = hours;
        }
        else {
            System.out.println("invalid value for hours! Changing value to 0.");
            this.hours = 0;
        }
    }

    public void setTime(int hours, int minutes, int seconds) {
        setSeconds(seconds);
        setMinutes(minutes);
        setHours(hours);
    }

    // Методы по увеличению часов, минут, секунд НА какое-то количество.
    // Увеличение на количество часов. При переполнении берется остаток от деления на 24.
    public void addHours(int hours) {
        this.hours = (this.hours + hours) % 24;
    }

    // Увеличение на количество минут. Если минут больше 60, то передадим часы в addHours.
    public void addMinutes(int minutes) {
        // "Запомним" количество часов
        minutes += this.minutes;
        this.minutes = minutes % 60;
        int hours = minutes / 60;
        if (hours > 0) {
            addHours(hours);
        }
    }

    // Увеличение на количество секунд. Если секунд больше 60, то передадим минуты в addHours.
    public void addSeconds(int seconds) {
        seconds += this.seconds;
        this.seconds = seconds % 60;
        int minutes = seconds / 60;
        if (minutes > 0) {
            addMinutes(minutes);
        }
    }

    // Увеличение на количество часов, минут, секунд в одном методе
    public void addTime(int hours, int minutes, int seconds) {
        addHours(hours);
        addMinutes(minutes);
        addSeconds(seconds);
    }

}
