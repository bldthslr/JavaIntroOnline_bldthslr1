package u4_2_Agregation_And_Composition.task4;

import java.math.BigInteger;

/**
 * Исполняемый класс с методом main, демонстрирующий работу классов BankAccount, BankAccountList, Client.
 * В данном классе:
 * 1) Создаются номера счетов в виде статических объектов BigInteger;
 * 2) Создаются статические объекты типа AccountSpecifications, которые содержат информацию об одном банковском счете;
 * 3) Создается статический объект клиент, который содержит несколько счетов
 * 4) В методе main в консоль последовательно выводится:
 * 4.1) Список всех счетов
 * 4.2) Обновленный список счетов с разблокировкой первого по счету заблокированного счета
 * 4.3) Результаты поиска счетов по различным параметрам
 * 4.4) Сортировки счетов по возрастанию и убыванию баланса
 * 4.5) Подсчет общих сумм всех счетов, всех положительных и отрицательных счетов
 */
public class Usage {
    // Создадим номера счетов в виде объектов BigInteger
    static BigInteger num1 = new BigInteger("50570457100000006741");
    static BigInteger num2 = new BigInteger("50487233600000006950");
    static BigInteger num3 = new BigInteger("50734451200000006574");
    static BigInteger num4 = new BigInteger("40981130800000006337");
    static BigInteger num5 = new BigInteger("40771314800000005332");
    static BigInteger num6 = new BigInteger("40565616600000008174");
    static BigInteger num7 = new BigInteger("50328667800000005630");
    static BigInteger num8 = new BigInteger("40405870900000007233");
    static BigInteger num9 = new BigInteger("50195479300000002357");
    static BigInteger num10 = new BigInteger("50560513800000007321");

    // Создадим 10 объектов AccountSpecifications\
    static AccountSpecifications acc1 = new AccountSpecifications(num1);
    static AccountSpecifications acc2 = new AccountSpecifications(num2, 2000, Bank.Currency.EUR);
    static AccountSpecifications acc3 = new AccountSpecifications(num3, -2500, Bank.Currency.USD, Bank.AccountTypes.LOAN);
    static AccountSpecifications acc4 = new AccountSpecifications(num4, 123454.22, Bank.AccountTypes.DEPOSIT);
    static AccountSpecifications acc5 = new AccountSpecifications(num5, 1_000_000, true);
    static AccountSpecifications acc6 = new AccountSpecifications(num6, -30_000, Bank.AccountTypes.LOAN);
    static AccountSpecifications acc7 = new AccountSpecifications(num7, 1000, Bank.Currency.USD, Bank.AccountTypes.PAYMENT);
    static AccountSpecifications acc8 = new AccountSpecifications(num8, 300, Bank.Currency.EUR, true);
    static AccountSpecifications acc9 = new AccountSpecifications(num9, 200_000);
    static AccountSpecifications acc10 = new AccountSpecifications(num10, -100_000, Bank.AccountTypes.DEPOSIT, true);

    // Создадим объект типа клиент
    static Client client1 = new Client("Ivan Ivanov", "+7(920)8887766", new BankAccountList(acc1, acc2, acc3, acc4,
            acc5, acc6, acc7, acc8, acc9, acc10));

    public static void main(String[] args) {
        // Выведем на экран все счета
        System.out.println(client1.toString());
        System.out.println();
        // Выполним поиск всех заблокированных счетов, и первый из них разблокируем
        client1.searchBlockedAccounts().get(0).setBlocked(false);
        // Выведем на экран счета для проверки (счет №5 должен разблокироваться)
        System.out.println(client1.toString());
        System.out.println();

        // Поиск счетов:
        // По номеру
        System.out.println("Search by number:");
        System.out.println(client1.searchByNumber("50328667800000005630").toString());
        System.out.println();
        // По типу
        System.out.println("Search all deposit accounts:");
        System.out.println(client1.BAListToString(client1.searchByAccountType(Bank.AccountTypes.DEPOSIT)));
        System.out.println();
        // По валюте
        System.out.println("Search all EUR accounts:");
        System.out.println(client1.BAListToString(client1.searchByCurrency(Bank.Currency.EUR)));
        System.out.println();
        // Все разблокированные
        System.out.println("Search all Unblocked:");
        System.out.println(client1.BAListToString(client1.searchUnblockedAccounts()));
        System.out.println();

        // Сортировки
        // Сортировка по балансу по возрастанию
        System.out.println("sorting accounts by balance in ascending order");
        System.out.println(client1.BAListToString(client1.sortByBalanceAscending()));
        System.out.println();
        // Сортировка по балансу по убыванию
        System.out.println("sorting accounts by balance in descending order");
        System.out.println(client1.BAListToString(client1.sortByBalanceDescending()));
        System.out.println();

        // Подсчет общих сумм
        // Вычисление общей суммы по счетам, в рублях
        System.out.println("Total amount of all accounts: " + client1.totalSumma() + " RUR.");
        // Вычисление общей суммы по счетам, в EUR
        System.out.println("Total amount of all accounts: " + client1.totalSumma(Bank.Currency.EUR) + " EUR.");
        // Вычисление общей суммы только по положительным счетам, в рублях
        System.out.println("Total amount of all positive balanced accounts: " + client1.totalSummaPositive() + " RUR.");
        // Вычисление общей суммы только по положительным счетам, в EUR
        System.out.println("Total amount of all positive balanced accounts: " + client1.totalSummaPositive(Bank.Currency.EUR) + " EUR.");
        // Вычисление общей суммы только по отрицательным счетам, в рублях
        System.out.println("Total amount of all negative balanced accounts: " + client1.totalSummaNegative() + " RUR.");
        // Вычисление общей суммы только по отрицательным счетам, в EUR
        System.out.println("Total amount of all negative balanced accounts: " + client1.totalSummaNegative(Bank.Currency.EUR) + " EUR.");

    }
}
