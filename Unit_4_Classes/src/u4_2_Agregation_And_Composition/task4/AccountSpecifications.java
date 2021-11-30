package u4_2_Agregation_And_Composition.task4;

import java.math.BigInteger;

/**
 * Класс для хранения параметров, передаваемых в конструктор класса BankAccount.
 * Данный класс имеет перегруженный конструктор, для создания всех возможных сочетаний задаваемых параметров и
 * параметров по умолчанию.
 * Данный подход позволяет создавать класс BankAccount c единственным конструктором, содержащим данный объек.
 *
 * Поскольку данный класс нужен в качестве "обертки" для передачи параметров в конструктор класса BankAccount,
 * он будет содержать в себе только поля и перегруженный конструктор для определения значений по умолчанию.
 *
 * Класс Bank содержит перечисления, необходимые для создания объекта данного класса (возможные валюты, типы счетов).
 */
public class AccountSpecifications {
    private BigInteger number;
    private double balance;
    private Bank.Currency currency;
    private Bank.AccountTypes type;
    private boolean isBlocked;

    public AccountSpecifications (BigInteger number, double balance, Bank.Currency currency, Bank.AccountTypes type, boolean isBlocked) {
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.isBlocked = isBlocked;
    }

    public AccountSpecifications (BigInteger number, double balance, Bank.Currency currency, Bank.AccountTypes type) {
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.isBlocked = false;
    }

    public AccountSpecifications (BigInteger number, double balance, Bank.Currency currency, boolean isBlocked) {
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.type = Bank.AccountTypes.PAYMENT;
        this.isBlocked = isBlocked;
    }

    public AccountSpecifications (BigInteger number, double balance, Bank.AccountTypes type, boolean isBlocked) {
        this.number = number;
        this.balance = balance;
        this.currency = Bank.Currency.RUR;
        this.type = type;
        this.isBlocked = isBlocked;
    }

    public AccountSpecifications (BigInteger number, Bank.Currency currency, Bank.AccountTypes type, boolean isBlocked) {
        this.number = number;
        this.balance = 0;
        this.currency = currency;
        this.type = type;
        this.isBlocked = isBlocked;
    }

    public AccountSpecifications (BigInteger number, double balance, Bank.Currency currency) {
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.type = Bank.AccountTypes.PAYMENT;
        this.isBlocked = false;
    }

    public AccountSpecifications (BigInteger number, double balance, Bank.AccountTypes type) {
        this.number = number;
        this.balance = balance;
        this.currency = Bank.Currency.RUR;
        this.type = type;
        this.isBlocked = false;
    }

    public AccountSpecifications (BigInteger number, double balance, boolean isBlocked) {
        this.number = number;
        this.balance = balance;
        this.currency = Bank.Currency.RUR;
        this.type = Bank.AccountTypes.PAYMENT;
        this.isBlocked = isBlocked;
    }

    public AccountSpecifications (BigInteger number, Bank.Currency currency, Bank.AccountTypes type) {
        this.number = number;
        this.balance = 0;
        this.currency = currency;
        this.type = type;
        this.isBlocked = false;
    }

    public AccountSpecifications (BigInteger number, Bank.Currency currency, boolean isBlocked) {
        this.number = number;
        this.balance = 0;
        this.currency = currency;
        this.type = Bank.AccountTypes.PAYMENT;
        this.isBlocked = isBlocked;
    }

    public AccountSpecifications (BigInteger number, Bank.AccountTypes type, boolean isBlocked) {
        this.number = number;
        this.balance = 0;
        this.currency = Bank.Currency.RUR;
        this.type = type;
        this.isBlocked = isBlocked;
    }

    public AccountSpecifications (BigInteger number, double balance) {
        this.number = number;
        this.balance = balance;
        this.currency = Bank.Currency.RUR;
        this.type = Bank.AccountTypes.PAYMENT;
        this.isBlocked = false;
    }

    public AccountSpecifications (BigInteger number, Bank.Currency currency) {
        this.number = number;
        this.balance = 0;
        this.currency = currency;
        this.type = Bank.AccountTypes.PAYMENT;
        this.isBlocked = false;
    }

    public AccountSpecifications (BigInteger number, Bank.AccountTypes type) {
        this.number = number;
        this.balance = 0;
        this.currency = Bank.Currency.RUR;
        this.type = type;
        this.isBlocked = false;
    }

    public AccountSpecifications (BigInteger number, boolean isBlocked) {
        this.number = number;
        this.balance = 0;
        this.currency = Bank.Currency.RUR;
        this.type = Bank.AccountTypes.PAYMENT;
        this.isBlocked = isBlocked;
    }

    public AccountSpecifications (BigInteger number) {
        this.number = number;
        this.balance = 0;
        this.currency = Bank.Currency.RUR;
        this.type = Bank.AccountTypes.PAYMENT;
        this.isBlocked = false;
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
}
