package u4_2_Agregation_And_Composition.task4;

import java.util.List;

/**
 * Класс клиента. Клиент может иметь имя, телефон, а так же один объект BankAccountList, хранящий ифнормацию
 * о всех счетах клиента. При этом методы для работы со счетами дублируются из класса BankAccountList.
 */
public class Client {
    private String name;
    private String phone;
    private BankAccountList bankAccountList;

    public Client (String name, String phone, BankAccountList bankAccountList) {
        this.name = name;
        this.phone = phone;
        this.bankAccountList = bankAccountList;
    }

    // Используем методы, описанные в bankAccountList
    public void addBankAccounts(AccountSpecifications accSpec) {
        bankAccountList.addBankAccounts(accSpec);
    }

    public BankAccount searchByNumber (String val) {
        return bankAccountList.searchByNumber(val);
    }

    public List<BankAccount> searchByCurrency (Bank.Currency currency) {
        return bankAccountList.searchByCurrency(currency);
    }

    public List<BankAccount> searchByAccountType (Bank.AccountTypes accountType) {
        return bankAccountList.searchByAccountType(accountType);
    }

    public List<BankAccount> searchUnblockedAccounts() {
        return bankAccountList.searchUnblockedAccounts();
    }

    public List<BankAccount> searchBlockedAccounts() {
        return bankAccountList.searchBlockedAccounts();
    }

    public List<BankAccount> sortByBalanceDescending() {
        return bankAccountList.sortByBalanceDescending();
    }

    public List<BankAccount> sortByBalanceAscending() {
        return bankAccountList.sortByBalanceAscending();
    }

    public double totalSumma() {
        return bankAccountList.totalSumma();
    }

    public double totalSummaPositive() {
        return bankAccountList.totalSummaPositive();
    }

    public double totalSummaNegative() {
        return bankAccountList.totalSummaNegative();
    }

    public double totalSumma(Bank.Currency currency) {
       return bankAccountList.totalSumma(currency);
    }

    public double totalSummaPositive(Bank.Currency currency) {
        return bankAccountList.totalSummaPositive(currency);
    }

    public double totalSummaNegative(Bank.Currency currency) {
        return bankAccountList.totalSummaNegative(currency);
    }

    // Приводим объект BankAccountList к типу String
    public String BAListToString(List<BankAccount> list) {
        StringBuilder rez = new StringBuilder();
        for (BankAccount bankAccount : list) {
            rez.append(bankAccount.toString()).append("\n");
        }
        return rez.toString();
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\''  +
                ", bankAccountList = "  + '\n'
                + BAListToString(bankAccountList.getBankAccounts()) +
                '}';
    }
}

