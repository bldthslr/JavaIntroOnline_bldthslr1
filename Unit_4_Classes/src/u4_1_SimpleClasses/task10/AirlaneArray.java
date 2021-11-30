package u4_1_SimpleClasses.task10;

import java.util.Arrays;

/**
 * Класс, агрегирующий массив объектов Airlanes, и включающий методы для работы с ним.
 */

public class AirlaneArray {
    private Airlane[] airlanes;

    // Конструктор
    public AirlaneArray (Airlane ... airlanes){
        this.airlanes = airlanes;
    }

    // Добавление книги в конец массива
    public void addAirlane (Airlane airlane) {
        airlanes = Arrays.copyOf(airlanes, airlanes.length + 1);
        airlanes[airlanes.length - 1] = airlane;
    }

    // Удаление книги по индексу
    public void deleteAirlane(int index) {
        // Сдвиг влево
        for (int i = index; i < airlanes.length - 1; i++) {
            airlanes[i] = airlanes[i-1];
        }
        // "Обрезаем" последний элемент
        airlanes = Arrays.copyOf(airlanes, airlanes.length - 1);
    }

    // Геттеры
    public Airlane getAirlane(int number) {
        return airlanes[number];
    }

    public int getLength() {
        return airlanes.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < airlanes.length; i++) {
            result.append("Airlane #").append(i+1).append("\n");
            result.append(airlanes[i].toString());
            result.append("\n");
        }
        return result.toString();
    }
}
