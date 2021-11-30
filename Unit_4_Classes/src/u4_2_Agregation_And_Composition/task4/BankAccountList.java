package u4_2_Agregation_And_Composition.task4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения счетов одного клиента. Так же в данном классе предстваленна вся логика работы со счетами.
 * В данном классе реализуется отношение "композиции", т.е. счета (объекты класса BankAccount)
 * будут создаваться непосредственно в этом классе из объектов AccountSpecifications.
 * Соответственно, получить доступ непосредственно к объектам счетов из других классов не получится.
 */

public class BankAccountList {
    List<BankAccount> bankAccounts = new ArrayList<>();

    // Пример использования композиции
    // Конструктор, в котором создается новый объект класса BankAccount, получая в качестве параметра AccountSpecifications
    public BankAccountList(AccountSpecifications... accountSpecifications) {
        for (AccountSpecifications accountSpecification : accountSpecifications) {
            bankAccounts.add(new BankAccount(accountSpecification));
        }
    }

    // Добавление счета
    public void addBankAccounts(AccountSpecifications accSpec) {
        bankAccounts.add(new BankAccount(accSpec));
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    // Алгоритмы поиска
    // Поиск одного номера по номеру счета, получаемому в виде String,
    public BankAccount searchByNumber (String val) {
        BigInteger number;
        try {
            number = new BigInteger(val);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getNumber().equals(number)) {
                return bankAccount;
            }
        }
        return null;
    }

    // Поиск по валюте. Возвращает list<BankAccount>
    public List<BankAccount> searchByCurrency (Bank.Currency currency) {
        List<BankAccount> rez = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getCurrency() == currency) {
                rez.add(bankAccount);
            }
        }
        return rez;
    }

    // Поиск по типу счета. Возвращает list<BankAccount>
    public List<BankAccount> searchByAccountType (Bank.AccountTypes accountType) {
        List<BankAccount> rez = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getType() == accountType) {
                rez.add(bankAccount);
            }
        }
        return rez;
    }

    // Поиск всех разблокированных счетов. Возвращает list<BankAccount>
    public List<BankAccount> searchUnblockedAccounts() {
        List<BankAccount> rez = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            if (!bankAccount.isBlocked()) {
                rez.add(bankAccount);
            }
        }
        return rez;
    }

    // Поиск всех заблокированных счетов. Возвращает list<BankAccount>
    public List<BankAccount> searchBlockedAccounts() {
        List<BankAccount> rez = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.isBlocked()) {
                rez.add(bankAccount);
            }
        }
        return rez;
    }


    // Алгоритмы сортировки. Во всех сортировка используется сортировка шелла.
    // Сортировки возвращают новый список счетов

    // Сортировка по балансу. При этом необходимо разные счета привести к одной валюте, используя метод получения курсов
    // валют getExchangeRate из класса Bank.
    // Данная метод сортирует балансы по убыванию, т.е. от большего к меньшему
    public List<BankAccount> sortByBalanceDescending() {
        List<BankAccount> rez = new ArrayList<>(bankAccounts);
        BankAccount tmp;
        for (int i = 0; i < rez.size() - 1; i++) {
            while((rez.get(i).getBalance() * Bank.getExchangeRate(rez.get(i).getCurrency())) <
                    ((rez.get(i+1).getBalance() * Bank.getExchangeRate(rez.get(i+1).getCurrency())))) {
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

    // Сортировка балансов по возрастанию, от меньшего к большему
    public List<BankAccount> sortByBalanceAscending() {
        List<BankAccount> rez = new ArrayList<>(bankAccounts);
        BankAccount tmp = null;
        for (int i = 0; i < rez.size() - 1; i++) {
            while((rez.get(i).getBalance() * Bank.getExchangeRate(rez.get(i).getCurrency())) >
                    ((rez.get(i+1).getBalance() * Bank.getExchangeRate(rez.get(i+1).getCurrency())))) {
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

    // Подсчет общей суммы в рублях всех положительных счетов.
    public double totalSumma() {
        double totalSumm = 0;
        for (BankAccount bankAccount : bankAccounts) {
            totalSumm += bankAccount.getBalance() * Bank.getExchangeRate(bankAccount.getCurrency());
        }
        return totalSumm;
    }

    // Подсчет общей суммы положительных счетов. По умолчанию подсчет в рублях
    public double totalSummaPositive() {
        double totalSumm = 0;
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getBalance() > 0) {
                totalSumm += bankAccount.getBalance() * Bank.getExchangeRate(bankAccount.getCurrency());
            }
        }
        return totalSumm;
    }

    // Подсчет общей суммы отрицательных счетов. По умолчанию подсчет в рублях
    public double totalSummaNegative() {
        double totalSumm = 0;
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getBalance() < 0) {
                totalSumm += bankAccount.getBalance() * Bank.getExchangeRate(bankAccount.getCurrency());
            }
        }
        return totalSumm;
    }


    // Подсчет общей суммы с учетом валюты
    public double totalSumma(Bank.Currency currency) {
        double totalSumm = 0;
        totalSumm = totalSumma() / Bank.getExchangeRate(currency);
        return totalSumm;
    }

    // Подсчет общей суммы положительных счетов с учетом валюты
    public double totalSummaPositive(Bank.Currency currency) {
        double totalSumm = 0;
        totalSumm = totalSummaPositive() / Bank.getExchangeRate(currency);
        return totalSumm;
    }

    // Подсчет общей суммы отрицательных счетов с учетом валюты
    public double totalSummaNegative(Bank.Currency currency) {
        double totalSumm = 0;
        totalSumm = totalSummaNegative() / Bank.getExchangeRate(currency);
        return totalSumm;
    }

}
