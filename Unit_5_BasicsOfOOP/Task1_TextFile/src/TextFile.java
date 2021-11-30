/**
 * Класс для описания текстового файла. Наследуется от абстрактного класса file, содержит дополнительное текстовое поле
 * content (содержимое).
 */
public class TextFile extends File{
    private String content = "";

    // Конструктор создания пустого файла без указания директории
    public TextFile(String name) {
        super(name);
    }

    // Конструктор создания пустого файла с указанием директории
    public TextFile(String name, String path) {
        super(name, path);
    }

    //Геттер
    public String getContent() {
        return content;
    }

    @Override
    public void delete() {
        this.content = null;
        super.delete();
    }
    @Override
    public void printContent() {
        System.out.println(content);
    }

    @Override
    public void complement(Object obj) {
        content = content.concat((String) obj);
    }
}
