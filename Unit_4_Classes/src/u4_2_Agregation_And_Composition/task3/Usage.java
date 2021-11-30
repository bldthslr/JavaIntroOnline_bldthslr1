package u4_2_Agregation_And_Composition.task3;

/**
 * Использование класса Country и классов State, District, City.
 *
 * Для тестирования данных классов создадим вымышленную страну программистов, добавим в неё города, районы и области.
 * Нужно отметить, что для того, чтобы использовать создание с конструктором, необходимо сначала создать города,
 * затем районы, затем области, и затем страну.
 */
public class Usage {
    // Создадим объекты городов
    public static City javaCity1 = new City("JavaProCoders", 121.43);
    public static City javaCity2 = new City("JavaJuniors", 82.86);
    public static City javaCity3 = new City("JavaTeamLeadersPro", 133.99);

    public static City pythonCity1 = new City("PythonDataScientists", 67.22);
    public static City pythonCity2 = new City("DjangoPros", 111.22);
    public static City pythonCity3 = new City("PythonJuniors", 33.83);

    public static City phpCity1 = new City("PhpBestCoders", 100.1);
    public static City phpCity2 = new City("PhpJuniors", 10.84);

    public static City javaScriptCity1 = new City("JSReactCoders", 151.2);
    public static City javaScriptCity2 = new City("JSAngularCoders", 152.34);
    public static City javaScriptCity3 = new City("JSVueCoders", 144.94);
    public static City javaScriptCity4 = new City("JSJuniorCoders", 255.32);

    public static City htmlCity1 = new City("HTMLPros", 64.3);
    public static City cssCity1 = new City("CSSPros", 52.2);


    // Создадим объекты районов
    public static District district1 = new District("Java", 10234.56,
            javaCity1, javaCity2, javaCity3);
    public static District district2 = new District("Python", 8912.31,
            pythonCity1, pythonCity2, pythonCity3);
    public static District district3 = new District("Php", 8831.95,
            phpCity1, phpCity2);
    public static District district4 = new District("JavaScript", 22451.33,
            javaScriptCity1, javaScriptCity2, javaScriptCity3, javaScriptCity4);
    public static District district5 = new District("HTML+CSS", 5451.33,
            htmlCity1, cssCity1);

    // Создадим объекты областей
    public static State state1 = new State("Backend", javaCity3, district1, district2, district3);
    public static State state2 = new State("Frontend", javaScriptCity1, district4, district5);

    // Создадим страну программистов :)
    public static Country codeCountry = new Country("Programmers", javaCity3, state1, state2);

    // В методе main вызовим методы, описанные в условии задачи
    public static void main(String[] args) {
        codeCountry.printCapital();
        codeCountry.printStates();
        codeCountry.printDistricts();
        codeCountry.printCities();
        codeCountry.printArea();
        codeCountry.printStateCenters();
    }
}
