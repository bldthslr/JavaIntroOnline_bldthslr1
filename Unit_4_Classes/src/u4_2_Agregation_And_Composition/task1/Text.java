package u4_2_Agregation_And_Composition.task1;

import java.util.Arrays;
import java.util.regex.*;

/**
 * "1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
 * консоль текст, заголовок текста."
 *
 * Для создания класса text будут использоваться классы Word и Sentence.
 * Класс Word имеет одно поле Word типа String.
 * Класс Sentence имеет поле Sentence типа String, а так же поле - массив объектов типа Word.
 * Данный класс Text имеет поле heading типа String для хранения заголовка текста, а так же поле массив типа Sentence
 * Класс текст использует перегруженный конструктор для того, чтобы принимать в качестве параметра как один объект
 * типа String в качестве целого текста, а затем разбивать его по предложениям, так и несколько String'ов в качестве
 * предложений, которые надо добавить в массив типа Sentence.
 *
 * Кроме методов, описанных в условии, добавлены геттеры и переопределен метод toString().
 */
public class Text {
    String heading;
    Sentence[] sentences;

    // Конструктор, принимающий заголовок текста и массив объектов Sentence
    public Text (String heading, Sentence... sentences) {
        this.heading = heading;
        this.sentences = sentences;
    }

    // Конструктор, принимающий заголовк текста и массив строк, которые надо преобразовать в объекты Sentence
    public Text(String heading, String ... sentences) {
        this.heading = heading;
        this.sentences = new Sentence[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            this.sentences[i] = new Sentence(sentences[i]);
        }
    }

    // Конструктор, принимающий заголовок текста и сам текст в формате String.
    public Text(String heading, String text) {
        this.heading = heading;
        /*
        Для того, чтобы разбить текст на предложения, необходимо при помощи регулярного выражения найти концовки всех
        предложений, добавить после них специальный символ, и сделать split по этому символу.
        В качестве данного "разделительного" символа используем '~'
         */
        // Для добавления специального символа в текст создадим его копию типа StringBuilder
        StringBuilder sbText = new StringBuilder(text);
        // Составим регулярное выражение
        Pattern pattern = Pattern.compile("[а-яa-z][.!?]+ ");
        // Создадим соответствие для текста
        Matcher matcher = pattern.matcher(text);
        // Поскольку изменять будем StringBuilder, добавим счетчик итераций
        int counter = 0;
        // Пока есть соответсвия
        while (matcher.find()) {
            // Вставляем символ '~' в текст на позицию конца вхождений входной строки, прибавляя counter
            // Поскольку вставка идет в StringBuilder, если не прибавлять счетчик, символ будет "съезжать" вправо
            sbText.insert(matcher.end() + counter, '~');
            counter++;
        }
        String[] sentences = text.split("~");
        this.sentences = new Sentence[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            this.sentences[i] = new Sentence(sentences[i]);
        }
    }

    // Геттеры
    public String getHeading() {
        return heading;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    // Возвращает массив предложений типа String
    public String[] getStringSentences() {
        String[] res = new String[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            res[i]= sentences[i].toString();
        }
        return res;
    }

    // Возвращает весь текст типа String
    public String getText() {
        return toString();
    }

    // Дополняет текст, добавляя предложение в конец массива с предложениями
    public void addSentence(String sentence) {
        Sentence[] temp = Arrays.copyOf(sentences, sentences.length + 1);
        Sentence added = new Sentence(sentence);
        temp[temp.length - 1] = added;
        sentences = temp;
    }

    // Печатает заголовок текста
    public void printHeading () {
        System.out.println(heading);
    }

    // Печатает текст целиком
    public void printText () {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Sentence sentence : sentences) {
            res.append(sentence.toString());
        }
        return res.toString();
    }
}
