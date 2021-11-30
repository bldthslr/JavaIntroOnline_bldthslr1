/**
 * Порождающий абстрактный класс, являющейся частью подарка.
 * Часть подарка содержит:
 * 1) Название
 * 2) Тип
 * 3) Цвет
 * Цвета описаны в отдельном enum.
 * Все наследующиеся классы должны переопределить toString(), equals() и hashCode().
 */
public abstract class Part {
    private final String name;
    private final String type;
    private final Colours colour;

    // Конструктор
    public Part(String name, String type, Colours colour) {
        // Приведем имя к виду "capitalized String" (Первый символ в верхнем регистре, остальные в нижнем)
        StringBuilder sb = new StringBuilder(name.toLowerCase());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        this.name = sb.toString();
        // Цвет
        this.colour = colour;
        // Приведем тип к нижнему регистру
        this.type = type.toLowerCase();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Colours getColour() {
        return colour;
    }

    // В классах-потомках необходимо переопределить методы toString(), equals() и hashCode()
    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
