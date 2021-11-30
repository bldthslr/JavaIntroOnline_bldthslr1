/**
 * Пример использования класса Payment.
 */
public class Usage {
    //Создадим пустой список покупок
    static Payment payment = new Payment();

    public static void main(String[] args) {
        // Добавим товары в список
        payment.addToProductList("Phone", "Iphone 10", 400);
        payment.addToProductList("Clothes", "T Shirt Men Short Sleeve Pure Cotton", 4.99, 5);
        payment.addToProductList("Accessories", "HOME J18 True Bluetooth Wireless Headphones With Low Delay", 12.43);
        // Выведем на экран список товаров
        System.out.println(payment.toString());
        // Добавим ещё товаров
        payment.addToProductList("Clothes", "T Shirt Men Short Sleeve Pure Cotton", 4.99);
        payment.addToProductList("Clothes", "Mens Business Casual Long Sleeved Shirt Classic", 8.95, 3);
        // Выведем на экран дополненный список товаров
        System.out.println();
        System.out.print("Updated ");
        System.out.println(payment.toString());
    }
}
