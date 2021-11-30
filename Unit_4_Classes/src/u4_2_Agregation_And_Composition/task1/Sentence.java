package u4_2_Agregation_And_Composition.task1;

/**
 * Класс sentence, использующийся в классе Text.
 */
public class Sentence {
    private Word[] words;
    private String sentence;

    public Sentence (String sentence) {
        this.sentence = sentence;
        String[] rawWords = sentence.split(" ");
        words = new Word[rawWords.length];
        for (int i = 0; i < rawWords.length; i++) {
            Word tmp = new Word(rawWords[i].replaceAll("[^A-Za-zА-Яа-я]", ""));
            words[i] = tmp;
        }
    }

    //Геттеры
    public int getNumberOfWords() {
        return words.length;
    }

    public Word[] getWords() {
        return words;
    }

    @Override
    public String toString() {
        return sentence;
    }
}
