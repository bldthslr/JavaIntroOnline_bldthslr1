import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * "1. Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
 * операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
 * алфавиту."
 *
 * Данный класс хранит в поле исходный текст и получает его в качестве параметра конструктора, или через сеттер.
 * Исходя из условия, в данном классе реализованы 3 метода, возвращающие измененный текст (объект класса String);
 * Использование данного класса представлено в классе Usage.
 */
public class TextAnalysis {
    // Поле для хранимого текста
    private String text;

    // Конструктор
    public TextAnalysis(String text) {
        this.text = text;
    }

    // Конструктор без параметра
    public TextAnalysis() {
        text = "";
    }

    // Геттер
    public String getText() {
        return text;
    }

    // Сеттер
    public void setText(String text) {
        this.text = text;
    }


    /**
     * Сортирует абзацы по количеству предложений.
     * Будем считать абзацем строку, которая началась после символа перевода строки.
     * @return текст, в котором абзацы отсортированы в порядке xxx
     */
    public String sortParagraphsByNumOfSent() {
        // Сохраним специальный символ для перевода строки
        String sls = System.lineSeparator();
        String[] splitText = text.split("[" + sls + "\n]");
        // Отсортируем массив абзацев
        String temp;
        for (int i = 0; i < splitText.length-1; i++) {
            while (splitText[i].length() > splitText[i+1].length()) {
                temp = splitText[i];
                splitText[i] = splitText[i+1];
                splitText[i+1] = temp;
                if (i > 0) {
                    i--;
                }
            }
        }
        // "Соберем результирующий текст
        StringBuilder res = new StringBuilder();
        for (String str: splitText) {
            res.append(str).append(sls);
        }
        // Вернем результат
        return res.toString();
    }

    /**
     * В каждом предложении исходного текста слова сортируются по длине.
     * При такой сортировке в тексте "потеряются" запятые.
     * @return текст с отсортированными предложениями.
     */
    public String sortSentencesByWordLength() {
        StringBuilder res = new StringBuilder();
        // Получим массив слов
        String[][] words = splitSentAndWords();
        // Для каждого предложения:
        for (int i = 0; i < words.length; i++) {
            // Получим и сохраним символ(ы) конца предложения
            Pattern pattern = Pattern.compile("[^a-zA-Zа-яёА-ЯЁ]+");
            Matcher matcher = pattern.matcher(words[i][words[i].length - 1]);
            String sentEnd = new String();
            if (matcher.find()) {
                sentEnd += matcher.group();
            }
            // Уберем все "лишние" символы
            for (int j = 0; j < words[i].length; j++) {
                words[i][j] = words[i][j].replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "");
            }
            // Отсортируем массив слов по длине
            String temp;
            for (int j = 0; j < words[i].length - 1; j++) {
                while (words[i][j].length() > words[i][j+1].length()) {
                    temp = words[i][j];
                    words[i][j] = words[i][j+1];
                    words[i][j+1] = temp;
                    if (j > 0) {
                        j--;
                    }
                }
            }
            // Соберем предложение в строку, и добавим в результат
            StringBuilder sent = new StringBuilder();
            for (int j = 0; j <  words[i].length - 1; j++) {
                sent.append(words[i][j]).append(' ');
            }
            // Добавим знаки конца предложения, и, если это не новая строка, то пробел после этого
            sent.append(words[i][words[i].length - 1]).append(sentEnd);
            if ((sent.charAt(sent.length() - 1) == '.')
                    || (sent.charAt(sent.length() - 1) == '!')
                    || (sent.charAt(sent.length() - 1) == '?')) {
                sent.append(' ');
            }
            // Добавим собранное предложение в результат
            res.append(sent);
        }
        return res.toString();
    }

    /**
     * Сортирует лексемы в предложениях по убыванию количества вхождений заданного символа, а в случае равенства – по
     * алфавиту
     * Регистр символа не учитывается, например, результат для символов 'A' и 'a' будет одинаковым!
     * @param symbol - заданный символ
     * @return - текст с отсортированными предложениями
     */
    public String sortSentByOccurSymbol(char symbol) {
        StringBuilder res = new StringBuilder();
        // Получим двумерный массив предложений, в каждом предложении массив слов
        String[][] words = splitSentAndWords();
        // Сделаем копию массива
        int[][] intWords = new int[words.length][];
        for (int i = 0; i < intWords.length; i++) {
            intWords[i] = new int[words[i].length];
        }
        // Заполним массив количеством вхождения символа в слова
        for (int i = 0; i < intWords.length; i++) {
            for (int j = 0; j < intWords[i].length; j++) {
                intWords[i][j] = numberOfOccurrences(words[i][j], symbol);
            }
        }
        // Для каждого предложения:
        for (int i = 0; i < words.length; i++) {
            // Получим и сохраним символ(ы) конца предложения
            Pattern pattern = Pattern.compile("[^a-zA-Zа-яёА-ЯЁ]+");
            Matcher matcher = pattern.matcher(words[i][words[i].length - 1]);
            String sentEnd = new String();
            if (matcher.find()) {
                sentEnd += matcher.group();
            }
            // Уберем все "лишние" символы
            for (int j = 0; j < words[i].length; j++) {
                words[i][j] = words[i][j].replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "");
            }
            // Отсортируем оба массива так, чтобы индексы у обоих массивов совпадали.
            // Отсортируем массив слов по длине
            String tempStr;
            int tempInt;
            // Сначала отсортируем массив по количеству вхождений символа:
            for (int j = 0; j < intWords[i].length - 1; j++) {
                while (intWords[i][j] < intWords[i][j + 1]) {
                    // Обмен местами слов
                    tempStr = words[i][j];
                    words[i][j] = words[i][j + 1];
                    words[i][j + 1] = tempStr;
                    // Обмен местами вхождений в массиве intWords
                    tempInt = intWords[i][j];
                    intWords[i][j] = intWords[i][j + 1];
                    intWords[i][j + 1] = tempInt;
                    // Сдвиг
                    if (j > 0) {
                        j--;
                    }
                }
            }
            // Теперь отсортируем по алфавиту те слова, в которых совпадает количество вхождений
            for (int j = 0; j < intWords[i].length - 1; j++) {
                while ((words[i][j].compareTo(words[i][j+1]) > 0) && (intWords[i][j] == intWords[i][j+1])) {
                    // Обмен местами слов
                    tempStr = words[i][j];
                    words[i][j] = words[i][j + 1];
                    words[i][j + 1] = tempStr;
                    // Обмен местами вхождений в массиве intWords
                    tempInt = intWords[i][j];
                    intWords[i][j] = intWords[i][j + 1];
                    intWords[i][j + 1] = tempInt;
                    // Сдвиг
                    if (j > 0) {
                        j--;
                    }
                }
            }
            // После сортировки соберем предложение:
            // Соберем предложение в строку, и добавим в результат
            StringBuilder sent = new StringBuilder();
            for (int j = 0; j <  words[i].length - 1; j++) {
                sent.append(words[i][j]).append(' ');
            }
            // Добавим знаки конца предложения, и, если это не новая строка, то пробел после этого
            sent.append(words[i][words[i].length - 1]).append(sentEnd);
            if ((sent.charAt(sent.length() - 1) == '.')
                    || (sent.charAt(sent.length() - 1) == '!')
                    || (sent.charAt(sent.length() - 1) == '?')) {
                sent.append(' ');
            }
            // Добавим собранное предложение в результат
            res.append(sent);
        }
        return res.toString();
    }

    // Разделение текста на предложения
    private String[] splitSentences() {
        // Для добавления специального символа в текст создадим его копию типа StringBuilder
        StringBuilder sbText = new StringBuilder(text);
        String sls = System.lineSeparator();
        // Составим регулярное выражение
        Pattern pattern = Pattern.compile("[а-яёa-z][.!?]+[ " + sls + "\n]");
        // Создадим соответствие для текста
        Matcher matcher = pattern.matcher(text);
        // Поскольку изменять будем StringBuilder, добавим счетчик итераций
        int counter = 0;
        // Пока есть соответствия
        while (matcher.find()) {
            // Вставляем символ '~' в текст на позицию конца вхождений входной строки, прибавляя counter
            // Поскольку вставка идет в StringBuilder, если не прибавлять счетчик, символ будет "съезжать" вправо
            sbText.insert(matcher.end() + counter, '~');
            counter++;
        }
        String[] sentences = sbText.toString().split("~");
        return sentences;
    }

    // Разбивает текст на предложения и лексемы, возвращая их в виде двумерного массива
    private String[][] splitSentAndWords() {
        String[] splitText = splitSentences();
        String[][] res = new String[splitText.length][];
        for (int i = 0; i < splitText.length; i++) {
            res[i] = splitText[i].split(" ");
        }
        return res;
    }

    // Подсчитывает в строке количество вхождений символа, возвращает int. Регистр символа не учитывается!
    private int numberOfOccurrences (String word, char symbol) {
        int res = 0;
        Pattern pattern = Pattern.compile(Character.toString(symbol).toUpperCase());
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            res++;
        }
        pattern = Pattern.compile(Character.toString(symbol).toLowerCase());
        matcher = pattern.matcher(word);
        while (matcher.find()) {
            res++;
        }
        return res;
    }
}
