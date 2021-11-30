package u4_1_SimpleClasses.task1;

/**
 * Использование класса "Test1".
 */
public class Test1Usage {
    public static void main(String[] args) {
        Test1 test = new Test1();
        test.printFirst();          //0
        test.printSecond();         //0
        test.changeFirst(5);
        test.changeSecond(-7);
        test.printSum();            //-2
        test.printMax();            //5
    }
}
