/**
 * Использование класса TextFile
 */
public class Usage {
    public static void main(String[] args) {
        // Создание текстового файла
        TextFile test = new TextFile("Test.txt");
        // Выведем на экран его абсолютный путь, а так же попробуем вывести содержимое
        System.out.println(test.getAbsolutePath());
        test.printContent();
        // Переименуем файл, и проверим результат
        test.rename("NewNameTest.txt");
        System.out.println(test.getAbsolutePath());
        // Добавим содержимое в текст файла, и выведем на экран
        test.complement("Это тестовый текстовый файл!\nМеня создали в методе main класса Usage Проекта TextFile :)");
        test.printContent();
        // Удалим текстовый файл, и попробуем вывести на экран его имя и содержимое
        test.delete();
        System.out.println(test.getName());
        test.printContent();

    }
}
