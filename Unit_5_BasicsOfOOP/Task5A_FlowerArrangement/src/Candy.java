import java.util.Objects;

/**
 * Класс "Сладость", является частью подарка и наследуется от абстрактного класса.
 * У сладости есть дополнительно поле "начинка".
 */
public class Candy extends Part{
    private final String filling;

    // Конструктор
    public Candy(String name, Colours colour, String filling) {
        super(name, "Candy", colour);
        // Приведем "начинку" к нижнему регистру
        this.filling = filling.toLowerCase();
    }

    /* Перегрузим конструктор
    Если материал в конструкторе не указан, будем считать, что упаковка картонная */
    public Candy(String name, Colours color) {
        super(name, "Packaging", color);
        this.filling = "";
    }

    // Геттеры
    public String getFilling() {
        return filling;
    }

    // Для конфеты важен цвет, название, и начинка
    @Override
    public String toString() {
        String rez;
        rez = getColour().toString() + " " + getName();
        if (!filling.equals("")) {
            rez += " with " + getFilling();
        }
        return rez;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType(), getColour(), getFilling());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candy)) return false;
        Candy candy = (Candy) o;
        return Objects.equals(getName(), candy.getName()) && Objects.equals(getType(), candy.getType())
                && getColour() == candy.getColour() && Objects.equals(getFilling(), candy.getFilling());
    }
}