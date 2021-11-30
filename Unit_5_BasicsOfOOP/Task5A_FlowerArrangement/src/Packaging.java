import java.util.Objects;

/**
 * Класс "Упаковка", является частью подарка и наследуется от абстрактного класса.
 * У упаковки есть дополнительно поле "материал".
 */
public class Packaging extends Part{
    private final String material;

    // Конструктор
    public Packaging(String name, Colours colour, String material) {
        super(name, "Packaging", colour);
        // Приведем "материал" к нижнему регистру
        this.material = material.toLowerCase();
    }

    /* Перегрузим конструктор
    Если материал в конструкторе не указан, будем считать, что упаковка картонная */
    public Packaging(String name, Colours colour) {
        super(name, "Packaging", colour);
        this.material = "paperboard";
    }

    // Геттеры
    public String getMaterial() {
        return material;
    }

    // Переопределим методы toString, equals, hashCode;
    @Override
    public String toString() {
        return getColour().toString().toLowerCase() + " " + getMaterial() + " " + getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType(), getColour(), getMaterial());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Packaging)) return false;
        Packaging packaging = (Packaging) o;
        return Objects.equals(getName(), packaging.getName()) && Objects.equals(getType(), packaging.getType())
                && getColour() == packaging.getColour() && Objects.equals(getMaterial(), packaging.getMaterial());
    }
}
