package u4_2_Agregation_And_Composition.task4;

import java.math.BigInteger;

/**
 * Класс для описания банковского счета.
 * У класса есть только один конструктор, использующий в качестве параметра объект класса AccountSpecifications
 */
public class BankAccount {
    private BigInteger number;
    private double balance;
    private Bank.Currency currency;
    private Bank.AccountTypes type;
    private boolean isBlocked;

    // Конструктор, использующий объект класса accountSpecifications
    public BankAccount(AccountSpecifications accountSpecifications) {
        number = accountSpecifications.getNumber();
        balance = accountSpecifications.getBalance();
        currency = accountSpecifications.getCurrency();
        type = accountSpecifications.getType();
        isBlocked = accountSpecifications.isBlocked();
    }

    // Геттеры
    public BigInteger getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public Bank.Currency getCurrency() {
        return currency;
    }

    public Bank.AccountTypes getType() {
        return type;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    // Сеттеры. Если аккаунт заблокирован, то операции с ним невозможны (кроме блокировки/разблокировки).
    public void setNumber(BigInteger number) {
        if (isBlocked) {
            return;
        }
        this.number = number;
    }

    public void setBalance(int balance) {
        if (isBlocked) {
            return;
        }
        this.balance = balance;
    }

    public void setCurrency(Bank.Currency currency) {
        if (isBlocked) {
            return;
        }
        this.currency = currency;
    }

    public void setType(Bank.AccountTypes type) {
        if (isBlocked) {
            return;
        }
        this.type = type;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        String blck;
        if (isBlocked) {
            blck = "BLOCKED";
        }
        else {
            blck = "Unblocked";
        }
        return "Account #" + number +
                " { balance = " + balance +
                " " + currency +
                ", type = " + type +
                ", " + blck + '}';
    }
}
