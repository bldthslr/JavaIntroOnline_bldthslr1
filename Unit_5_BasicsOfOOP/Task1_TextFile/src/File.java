/**
 * Абстрактный класс файла. Имеет как неабстрактные методы (например, переименовать или возвратить имя файла), так и
 * абстрактные методы (дополнить и вывести на консоль содержимое файла)
 */
public abstract class File {
    String name;
    Directory directory;

    // Создание нового пустого файла, в директории, откуда запускается Jar файл
    public File (String name) {
        this.name = name;
        this.directory = new Directory(System.getProperty("user.dir"));

    }
    // Создание нового пустого файла, с явным указанием директории
    public File (String name, String path) {
        this.name = name;
        this.directory = new Directory(path);
    }

    //Геттеры

    // Возвращает имя файла
    public String getName() {
        return name;
    }

    // Возвращает директорию файла
    public String getDirectory() {
        return directory.getPathname();
    }

    // Возвращает абсолютное имя файла (имя + директория)
    public String getAbsolutePath () {
        return directory.getPathname() + '\\' + name;
    }

    // Переименовать файл
    public void rename (String name) {
        this.name = name;
    }

    // Удалить файл
    public void delete() {
        name = null;
        directory = null;
        System.gc();
    }

    // Абстрактные методы файла

    // Вывести на консоль содержимое
    public abstract void printContent();

    // дополнить
    public abstract void complement(Object obj);

}
