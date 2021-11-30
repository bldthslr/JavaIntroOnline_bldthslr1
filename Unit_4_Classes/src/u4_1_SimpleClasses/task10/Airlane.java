package u4_1_SimpleClasses.task10;

/**
 * 10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 *
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 *
 * Класс, агрегирующий массив типа Airlane, предствален в классе AirlaneArray
 * Код, демонстрирующий возможности класса предстваленн в классе "AirlaneUsage".
 */

public class Airlane {

    private enum DayOfTheWeek {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
    private String destination, typeOfAircraft;
    private int flightNumber, departureHour, departureMinute;;
    private DayOfTheWeek dayOfTheWeek;

    // Конструктор, принимающий время прибытия в виде String "HH:MM", и разбивающий его на int departureHour, departureMinute
    public Airlane (String destination, int flightNumber, String typeOfAircraft, String departureTime,
                    String dayOfTheWeek)  {
        try {
            String[] depTime = departureTime.split(":");
            departureHour = Integer.parseInt(depTime[0]);
            departureMinute = Integer.parseInt(depTime[1]);
            if ((departureHour < 0) || (departureHour > 23)) {
                throw new RuntimeException("Error! Wrong departure hour value!");
            }
            if ((departureMinute < 0) || (departureMinute > 59)) {
                throw new RuntimeException("Error! Wrong departure minute value!");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.typeOfAircraft = typeOfAircraft;
        boolean flag = false;
        for (DayOfTheWeek day : DayOfTheWeek.values()) {
            if (day.toString().equals(dayOfTheWeek)) {
                this.dayOfTheWeek = day;
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("The name of such a day of the week was not found! Set to \"MONDAY\"");
            this.dayOfTheWeek = DayOfTheWeek.MONDAY;
        }
    }

    //Конструктор, принимающий в время прибытия в виде int Hours, int Minutes
    public Airlane (String destination, int flightNumber, String typeOfAircraft,
                    int departureHour, int departureMinute, String dayOfTheWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.typeOfAircraft = typeOfAircraft;
        this.departureHour = departureHour;
        this.departureMinute = departureMinute;
        boolean flag = false;
        for (DayOfTheWeek day : DayOfTheWeek.values()) {
            if (day.toString().equals(dayOfTheWeek)) {
                this.dayOfTheWeek = day;
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("The name of such a day of the week was not found! Set to \"MONDAY\"");
            this.dayOfTheWeek = DayOfTheWeek.MONDAY;
        }
    }


    // Геттеры
    public String getDestination() {
        return destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getTypeOfAircraft() {
        return typeOfAircraft;
    }

    public int getDepartureHour() {
        return departureHour;
    }

    public int getDepartureMinute() {
        return departureMinute;
    }

    // Возвращает время прибытия в виде "HH:MM"
    public String getDepartureTime() {
        String minutes, hours;

        if (this.departureMinute < 10) {
            minutes = "0" + this.departureMinute;
        }
        else {
            minutes = String.valueOf(this.departureMinute);
        }
        if (this.departureHour < 10) {
            hours = "0" + this.departureHour;
        }
        else {
            hours = String.valueOf(this.departureHour);
        }
        return hours + ':' + minutes;
    }

    // Возвращает день недели типа String
    public String getDayOfTheWeekString() {
        return dayOfTheWeek.toString();
    }

    public DayOfTheWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }


    // Сеттеры
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setTypeOfAircraft(String typeOfAircraft) {
        this.typeOfAircraft = typeOfAircraft;
    }

    public void setDepartureHour(int departureHour) {
        if ((departureHour < 0) || (departureHour > 59)) {
            System.out.println("Invalid hour value! Setting to 00");
            this.departureHour = 0;
        }
        else {
            this.departureHour = departureHour;
        }
    }

    public void setDepartureMinute(int departureMinute) {
        if ((departureMinute < 0) || (departureMinute > 23)) {
            System.out.println("Invalid minute value! Setting to 00");
            this.departureMinute = 0;
        }
        else {
            this.departureMinute = departureMinute;
        }
    }

    // Сеттер, принимающий время прибытия в виде String "HH:MM"
    public void setDepartureTime(String departureTime) {
        try {
            String[] depTime =  departureTime.split(":");
            this.departureHour = Integer.parseInt(depTime[0]);
            this.departureMinute = Integer.parseInt(depTime[1]);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error! Setting departure time to 00:00");
            this.departureHour = 0;
            this.departureMinute = 0;
        }
    }

    // Сеттер, устанавливающий день недели по входной строке типа String
    public void setDayOfTheWeek (String dayOfTheWeek) {
        boolean flag = false;
        for (DayOfTheWeek day : DayOfTheWeek.values()) {
            if (day.toString().equals(dayOfTheWeek)) {
                this.dayOfTheWeek = day;
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("The name of such a day of the week was not found! Set to \"MONDAY\"");
            this.dayOfTheWeek = DayOfTheWeek.MONDAY;
        }
    }

    // Проверка, является ли String днем недели из enum
    public boolean checkDayOfTheWeek (String checkString) {
        boolean res = false;
        for (DayOfTheWeek day : DayOfTheWeek.values()) {
            if (day.toString().equals(checkString)) {
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return  "Destination: "        + destination                + ";\n" +
                "Flight number: "      + flightNumber               + ";\n" +
                "Type of Aircraft: "   + typeOfAircraft             + ";\n" +
                "Departure Time: "     + getDepartureTime()         + ";\n" +
                "Day of the week: "    + dayOfTheWeek.toString()    + ";\n";
    }
}
