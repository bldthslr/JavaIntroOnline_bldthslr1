package u4_1_SimpleClasses.task8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Использование классов Customer и CustomerArray.
 *
 * Создадим несколько покупателей внутри данного класса. Так же создадим определенное количество покупателей, введя
 * их данные через консоль (ПРОВЕРКА вводимых данных на валидность НЕ проводится).
 * Далее через консоль введем нижнее и верхнее значение интервала для кредитных карт.
 * Далее выведем нужную информацию в консоль согласно условию задачи.
 * Многие методы классов (сеттеры в классе Customer и некоторые геттеры в классе CustomerArray) не используются.
 */
public class CustomerUsage {
    // Первый покупатель
    private static final Customer customer1 = new Customer("Petrov",
            "Petr",
            "Petrovich",
            "Moscow, Lenin st., 13",
            4276_1340_2289_3442L,
            179000003333222L
            );
    // Второй покупатель
    private static final Customer customer2 = new Customer("Ivanov",
            "Ivan",
            "Ivanovich",
            "Minsk, Lermontova st., 28/18",
            8504_9365_0794_7560L,
            192300000415551676L);

    // Создаем массив покупателей
    private static final CustomerArray customers = new CustomerArray(customer1, customer2);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Узнаем, какое количество покупателей необходимо добавить
        System.out.println("Input the number of customers you want to add: ");
        int numberOfCustomers = in.nextInt();
        // Добавляем покупателей, получая данные из потока ввода
        for (int i = 0; i < numberOfCustomers; i++) {
            try {
                // Считываем параметры
                System.out.println("Input surname:");
                String surname = in.next();
                System.out.println("Input name:");
                String name = in.next();
                System.out.println("Input patronymic:");
                String patronymic = in.next();
                System.out.println("Input address:");
                in.nextLine();
                String address = in.nextLine();
                System.out.println("Input credit card number:");
                long creditCard = in.nextLong();
                System.out.println("Input bank account number:");
                long bankAccount = in.nextLong();
                // Создаем "временного" покупателя, и добавляем его в массив
                Customer tempCustomer = new Customer(surname, name, patronymic, address, creditCard, bankAccount);
                customers.add(tempCustomer);
            }
            catch (Exception e) {
                System.out.println("An exception occurred, no new customer added!");
            }
        }

        // Считаем из потока ввода верхнюю и нижнюю границу для диапазона по кредитным картам
        System.out.println("Input the lower limit of the credit card range:");
        long lowerLimit = in.nextLong();
        System.out.println("Input the lower limit of the credit card range:");
        long upperLimit = in.nextLong();
        in.close();

        /* Найти и вывести:
        * a) список покупателей в алфавитном порядке;
        Выведем покупателей в алфавитном порядке. Для этого создадим массив типа String, содержащий ФИО, и отсортируем
        этот массив.
         */
        String[] fullName = new String[customers.getLength()];
        for (int i = 0; i < customers.getLength(); i++) {
            fullName[i] = customers.getCustomer(i).getFullName();
        }
        // Создадим новый массив, так как массив fullName понадобится для решения второй части задачи
        String[] res = Arrays.copyOf(fullName, fullName.length);
        Arrays.sort(res);
        System.out.println("List of buyers in alphabetical order: ");
        System.out.println(Arrays.toString(res));
        System.out.println();
        /*
         * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.
         * Для поиска таких покупателей сначала используем считанные раньше upperLimit и lowerLimit,
         * а затем пройдем по массиву CustomerArrays для поиска индексов.
         * Поскольку в массиве fullName индексы совпадают с индексами массива CustomerArrays,
         *  будем выводить на экран элементы массива fullName.
         */
        System.out.println("List of customers whose credit card number is in the specified range: ");
        for (int i = 0; i < customers.getLength(); i++) {
            long cur = customers.getCustomer(i).getCreditCard();
            if ((cur >= lowerLimit) && (cur <= upperLimit)) {
                System.out.println(fullName[i] + "; Credit card number: " + cur);
            }
        }

    }


}
