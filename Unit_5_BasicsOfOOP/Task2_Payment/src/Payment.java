import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Objects;

/**
 * "Задача 2.
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
 * нескольких товаров."
 *
 *
 * Класс Payment, описывающий покупку из нескольких товаров.
 * Класс содержит два поля:
 * 1) Список купленных товаров products. Товары идут друг за другом, и могут повторяться.
 * 2) Словарь Payment, содержащий купленные товары в качестве ключа и их количество в качестве значения.
 * Класс содержит внутренний класс Product - описание товара.
 *
 * Во время создания или заполнения покупки товарами (объектами типа Product) они добавляются в список products. Затем,
 * когда все товары добавлены, происходит инициализация словаря payment (метод initPayment).
 * Суть метода initPayment в том, что он "перемещает" товары из products в payment, при этом все повторы в products
 * записываются в payment как один товар, но с увеличивающимся количеством. После инициализации payment обнуляет
 * список products.
 *
 * В данном классе переопределен метод toString(), который, по логике, является конечным результатом работы класса.
 */
public class Payment {
    // Список купленных товаров
    private List<Product> products;
    // Словарь, содержащий объект товара как ключ и их количество как значение
    private Map<Product, Integer> payment;


    // Пустой конструктор (пустая покупка)
    public Payment(){
        // Создаем пустой список товаров
        this.products = new ArrayList<>();
    }

    // Конструктор, принимающий список купленных товаров
    public Payment(List<Product> products) {
        if (products != null) {
            this.products = products;
        }
        else {
            this.products = new ArrayList<>();
        }
    }

    /**
     * Внутренний класс для описания товара.
     * Товар имеет имя, цену, и определенный тип(категорию).
     * В данном классе переопределены методы toString(), equals() и hashCode().
     *
     * Данный класс описывает товар, при помощи объектов которого можно сформировать покупку из нескольких товаров.
     */
    private class Product {
        private String type;
        private String name;
        private double price;

        // Конструктор
        private Product(String type, String name, double price) {
            this.type = type;
            this.name = name;
            this.price = price;
        }

        // Переопределение equals
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Product)) return false;
            Product product = (Product) o;
            return Double.compare(product.price, price) == 0 && Objects.equals(type, product.type) && Objects.equals(name, product.name);
        }

        // Переопределение hashCode
        @Override
        public int hashCode() {
            return Objects.hash(type, name, price);
        }

        // Переопределение toString
        @Override
        public String toString() {
            return "Product \"" + name + "\": Price = " + price + ", type = " + type + '.';
        }

    }

    // Добавление товара в список покупок, в качестве параметра используется объект product
    public void addToProductList(Product product) {
        products.add(product);
    }

    // Добавление товара в список покупок, в качестве параметров принимаются параметры для создания product
    public void addToProductList(String type, String name, double price) {
        products.add(new Product(type, name, price));
    }

    /*
    Добавление товара в список покупок
    качестве параметров принимаются параметры для создания product, а так же количество этого товара
     */
    public void addToProductList(String type, String name, double price, int amount) {
        for (int i = 0; i < amount; i++) {
            addToProductList(type, name, price);
        }
    }

    // метод для инициализации словаря payment, который подсчитывает количество товаров в списке
    private void initPayment() {
        // Если объект Payment ещё не создан, то создадим его
        if (payment == null) {
            payment = new HashMap<Product, Integer>();
        }
        // Пройдем по списку покупок products, и каждую покупку добавим в словарь
        for (Product product : products) {
            // Если товар есть в словаре payment, инкремируем счетчик
            if (payment.containsKey(product)) {
                payment.put(product, payment.get(product) + 1);
            }
            // Если товара нет в payment, добавим его с количеством 1
            else {
                payment.put(product, 1);
            }
        }
        // Обнулим список покупок products
        products.clear();
    }

    // Возвращает цену всех товаров
    public double getTotalCost() {
        // Инициализируем словарь Payment (!)
        initPayment();
        // Объявляем результирующую переменную
        double res = 0.0;
        // Проходим по словарю с товарами, и умножаем их стоимость на количество
        for (Product product : payment.keySet()) {
            res += product.price * payment.get(product);
        }
        return res;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        // Инициализируем словарь Payment (!)
        initPayment();
        // Заполняем результирующий StringBuilder
        StringBuilder rez = new StringBuilder();
        rez.append("Payment List: \n");
        for (Product product : payment.keySet()) {
            rez.append(product.toString()).append(" Amount = ").append(payment.get(product)).append("\n");
        }
        // В конце добавим общую стоимость всех товаров
        rez.append("Total to be paid: ").append(getTotalCost()).append("!");
        return rez.toString();
    }
}
