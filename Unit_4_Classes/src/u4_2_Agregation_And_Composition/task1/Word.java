package u4_2_Agregation_And_Composition.task1;

/**
 * Класс Word, использующийся в классе Sentence.
 */
public class Word {
    private String word;

    public Word (String word) {
        this.word = word;
    }

    @Override
    public String toString () {
        return word;
    }
}
