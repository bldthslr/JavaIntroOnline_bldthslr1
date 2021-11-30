package u4_1_SimpleClasses.task8;

import java.util.Arrays;

/**
 * Класс, агрегирующий массив Customer, и включающий логику работы с этим массивом.
 */
public class CustomerArray {
    private Customer[] customers;

    // Конструктор
    public CustomerArray(Customer ... customers) {
        this.customers = customers;
    }

    // Добавление элемента в конец массива
    public void add (Customer customer) {
        customers = Arrays.copyOf(customers, customers.length + 1);
        customers[customers.length - 1] = customer;
    }

    // Удаление элемента по его индексу со смещением
    public void delete (int number) {
        // Сдвиг влево
        for (int i = number; i < customers.length - 1; i++) {
            customers[i] = customers[i+1];
        }
        //
        customers = Arrays.copyOf(customers, customers.length - 1);
    }

    // Геттеры
    public Customer getCustomer(int number) {
        return customers[number];
    }

    public int getLength() {
        return customers.length;
    }

    public int getIndex(int id) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int[] getAllID() {
        int[] res = new int[customers.length];
        for (int i = 0; i < customers.length; i++) {
            res[i] = customers[i].getId();
        }
        return res;
    }

    public String[] getAllSurnames() {
        String[] res = new String[customers.length];
        for (int i = 0; i < customers.length; i++) {
            res[i] = customers[i].getSurname();
        }
        return res;
    }

    public String[] getAllNames() {
        String[] res = new String[customers.length];
        for (int i = 0; i < customers.length; i++) {
            res[i] = customers[i].getName();
        }
        return res;
    }

    public String[] getAllPatronymics() {
        String[] res = new String[customers.length];
        for (int i = 0; i < customers.length; i++) {
            res[i] = customers[i].getPatronymic();
        }
        return res;
    }

    public String[] getAllAddresses() {
        String[] res = new String[customers.length];
        for (int i = 0; i < customers.length; i++) {
            res[i] = customers[i].getAddress();
        }
        return res;
    }

    public long[] getAllCreditCards() {
        long[] res = new long[customers.length];
        for (int i = 0; i < customers.length; i++) {
            res[i] = customers[i].getCreditCard();
        }
        return res;
    }

    public long[] getAllBankAccounts() {
        long[] res = new long[customers.length];
        for (int i = 0; i < customers.length; i++) {
            res[i] = customers[i].getBankAccount();
        }
        return res;
    }

    public String toString(int number) {
        return customers[number].toString();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < customers.length; i++) {
            res.append("Customer #").append(i).append(":\n");
            res.append(customers[i].toString()).append("\n");
        }
        return res.toString();
    }
}
