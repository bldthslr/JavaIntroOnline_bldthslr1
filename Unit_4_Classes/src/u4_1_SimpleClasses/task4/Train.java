package u4_1_SimpleClasses.task4;

/**
 * "4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
 * номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
 * назначения должны быть упорядочены по времени отправления."
 *
 *  Время отправления будем хранить в виде двух переменных - час отправления и минута отправления. В конструкторе, а
 *  так же сеттерах будем проверять эти значения на валидность (для часа: [0..23], для минут: [0..59])
 *
 *  Создание массива из пяти элементов типа Train, а так же логика работы с этим массивом предстваленна в классе
 *  "TrainUsage".
 */
public class Train {
    private String destination;
    private int number;
    // Переменные для хранения времени отправления
    private int departureHours;
    private int departureMinutes;

    /**
     * Конструктор класса Train. При инициализации полей departureHours и departureMinutes проводится проверка значений.
     * @param destination - название пункта назначения
     * @param number - номер поезда
     * @param departureHours - время отправления (часы)
     * @param departureMinutes - время отправления (минуты)
     */
    public Train(String destination, int number, int departureHours, int departureMinutes) throws IllegalArgumentException{
        this.destination = destination;
        this.number = number;
        if ((departureHours >= 0) && (departureHours <= 23)) {
            this.departureHours = departureHours;
        }
        // Если значение параметра времени в часах не проходит проверку, необходимо выкинуть исключение.
        else {
            throw new IllegalArgumentException("Invalid hour value.");
        }
        if ((departureMinutes >= 0) && (departureMinutes <= 59)) {
            this.departureMinutes = departureMinutes;
        }
        // Если значение параметра времени в минутах не проходит проверку, необходимо выкинуть исключение.
        else {
            throw new IllegalArgumentException("Invalid minute value.");
        }
    }

    //Геттеры
    public String getDestination() {
        return destination;
    }

    public int getNumber() {
        return number;
    }

    public int getDepartureHours() {
        return departureHours;
    }

    public int getDepartureMinutes() {
        return departureMinutes;
    }

    // Геттер для получения времени отправления типа String в формате "HH:MM".
    public String getDepartureTime() {
        String departureHours;
        String departureMinutes;
        // Добавим нули, если необходимо
        if (this.departureHours <= 9) {
            departureHours = "0" + this.departureHours;
        }
        else {
            departureHours = String.valueOf(this.departureHours);
        }
        if (this.departureMinutes <= 9) {
            departureMinutes = "0" + this.departureMinutes;
        }
        else {
            departureMinutes = String.valueOf(this.departureMinutes);
        }
        // Соберем результат в строку
        return (departureHours + ":" + departureMinutes);
    }

    // Сеттеры

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // Сеттеры с проверкой на допустимость значения. Здесь не будем выкидывать исключение, а просто сделаем warning print.
    public void setDepartureHours(int departureHours) {
        if ((departureHours >= 0) && (departureHours <= 23)) {
            this.departureHours = departureHours;
        }
        // Если значение параметра времени в часах не проходит проверку, необходимо предупредить об этом.
        else {
            System.out.println("Warning! Invalid value, hours not set!");
        }
    }
    public void setDepartureMinutes(int departureMinutes) {
        if ((departureMinutes >= 0) && (departureMinutes <= 59)) {
            this.departureMinutes = departureMinutes;
        }
        // Если значение параметра времени в часах не проходит проверку, необходимо предупредить об этом.
        else {
            System.out.println("Warning! Invalid value, hours not set!");
        }
    }

    // Создадим сеттер для определения времени в часах и минутах
    public void setDepartureTime (int hours, int minutes) {
        setDepartureHours(hours);
        setDepartureMinutes(minutes);
    }

}
