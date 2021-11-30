package u4_2_Agregation_And_Composition.task4;

/**
 * Класс банка. В контексте этой задачи банк "хранит" некоторые параметры, такие как возможные типы банковских счетов,
 * возможные доступные валюты, а так же курсы валют.
 */

import java.util.HashMap;

public class Bank {
    // Возможные валюты
    public enum Currency {
        RUR,
        USD,
        EUR
    }
    // Возможные типы счетов
    public enum AccountTypes {
        LOAN,
        PAYMENT,
        DEPOSIT
    }
    // Словарь для хранения курсов валют по отношению к RUB
    static HashMap<Currency, Double> exchangeRatesRub = new HashMap<>();

    // Сгенерируем HashMap
    private static void generateExchangeRatesRub() {
        exchangeRatesRub.put(Currency.RUR, 1.0);
        exchangeRatesRub.put(Currency.EUR, 86.16);
        exchangeRatesRub.put(Currency.USD, 72.34);
    }

    public static double getExchangeRate(Currency currency) {
        if (exchangeRatesRub.get(currency) == null) {
            generateExchangeRatesRub();
        }
        return exchangeRatesRub.get(currency);
    }

}
