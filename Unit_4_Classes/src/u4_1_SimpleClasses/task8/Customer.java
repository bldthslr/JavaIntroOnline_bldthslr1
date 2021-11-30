package u4_1_SimpleClasses.task8;



/**
 * "8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль. "
 * "Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале"
 *
 * Класс, агрегирующий массив типа Customer, предствален в классе CustomerArray
 * Код, демонстрирующий возможности класса предстваленн в классе "CustomerUsage".
 */
public class Customer {
    private int id;
    private String surname, name, patronymic, address;
    private long creditCard, bankAccount;

    // Конструктор, который принимает все значения, кроме id
    public Customer(String surname, String name, String patronymic, String address, long creditCard, long bankAccount) {
        id = (int) (Math.random() * 2147483646);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this. creditCard = creditCard;
        this.bankAccount = bankAccount;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public long getCreditCard() {
        return creditCard;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }

    // Сеттеры
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }

    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    //toString
    @Override
    public String toString() {
        return "ID: "            + id           + ";\n" +
                "Surname: "      + surname      + ";\n" +
                "Name: "         + name         + ";\n" +
                "Patronymic: "   + patronymic   + ";\n" +
                "Address: "      + address      + ";\n" +
                "Credit card: "  + creditCard   + ";\n" +
                "Bank account: " + bankAccount  + ".\n";
    }
}
