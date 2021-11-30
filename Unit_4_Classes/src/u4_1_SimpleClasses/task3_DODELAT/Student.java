package u4_1_SimpleClasses.task3_DODELAT;

/**
 * "3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
 * из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
 * номеров групп студентов, имеющих оценки, равные только 9 или 10."
 *
 * Создание массива из десяти объектов Student, а так же логика работы с ним предствалены в классе "StudentUsage".
 *
 * В данном классе массив оценок будет состоять из 5 элементов, а диапазон оценок - от 1 до 12.
 * Возможность вывода фамилий и номеров групп реализована следующим образом: если у студента среди оценок только оценки
 * 9 и 10 (напр. [9, 9, 10, 9, 10]), то его фамилия, инициалы и номер группы будут выведены на экран.
 *
 * Массив из 10 элементов данного класса создан в методе main класса StudentUsage.
 */
public class Student {
    private String name;
    private int groupNumber;
    // Массив с оценками.
    private int[] perfomance = new int[5];

    // Конструктор с дополнительными условиями для заполнения массива оценок.
    // При передаче в качестве параметра массива оценок меньшей длинны, недостающие оценки заполняются 12.
    // При передаче в качестве параметра массива оценок большей длинны, "хвост" не учитывается.
    public Student(String name, int groupNumber, int[] perfomance) {
        this.name = name;
        this.groupNumber = groupNumber;
        // Заполним массив оценок в цикле:
        for (int i = 0; i < this.perfomance.length; i++) {
            // Если в качестве аргумента передан массив меньшей длинны, все оценки до конца заполним высшим баллом (12)
            if ((i + 1) > perfomance.length) {
                this.perfomance[i] = 12;
            }
            // Если индекс в массиве-параметре не вышел за границы:
            else {
                // Если в массиве передана оценка меньше 1, то оставим 1.
                if (perfomance[i] < 1) {
                    this.perfomance[i] = perfomance[i];
                }
                // Если в массиве-параметре передана оценка больше 12, то оставим 12.
                else if (perfomance[i] > 12) {
                    this.perfomance[i] = 12;
                }
                // Если в массиве-параметре передана оценка в диапазоне [1..12], то передадим её в основной массив оценок
                else {
                    this.perfomance[i] = perfomance[i];
                }
            }
        }
    }

    // геттеры
    public String getName() {
        return name;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public int[] getPerfomance() {
        return perfomance;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    // Cеттер оценок (массива из 5 элементов). Алгоритм такой же, как и в конструкторе, переписывает весь массив оценок
    public void setPerfomance(int[] perfomance) {
        // Заполним массив оценок в цикле:
        for (int i = 0; i < this.perfomance.length; i++) {
            // Если в качестве аргумента передан массив меньшей длинны, все оценки до конца заполним высшим баллом (12)
            if ((i + 1) > perfomance.length) {
                this.perfomance[i] = 12;
            }
            // Если индекс в массиве-параметре не вышел за границы:
            else {
                // Если в массиве передана оценка меньше 1, то оставим 1.
                if (perfomance[i] < 1) {
                    this.perfomance[i] = perfomance[i];
                }
                // Если в массиве-параметре передана оценка больше 12, то оставим 12.
                else if (perfomance[i] > 12) {
                    this.perfomance[i] = 12;
                }
                // Если в массиве-параметре передана оценка в диапазоне [1..12], то передадим её в основной массив оценок
                else {
                    this.perfomance[i] = perfomance[i];
                }
            }
        }
    }

    // Сеттер одной оценки, при этом нужно передать оценку в диапазоне [1..12] и её номер в массиве [1..5]
    public void setGrade(int grade, int number) {
        // Если порядковый номер оценки в диапазоне [1..5], то выполним алгоритм изменения оценки
        if ((number > 0) && (number < 6)) {
            if (grade < 1) {
                this.perfomance[number-1] = 1;
            }
            else if (grade > 12) {
                this.perfomance[number-1] = 12;
            }
            else {
                this.perfomance[number-1] = grade;
            }
        }
    }

    // Метод печатает в консоль Фамилию с инициалами и номер группы студента, у которого все оценки равны 9 или 10.
    public void printGrades9And10() {
        // Флаг для проверки результата
        boolean flag = true;
        // В цикле пройдем по оценкам
        for (int i = 0; i < perfomance.length; i++) {
            if (!((perfomance[i] == 9) || (perfomance[i] == 10))) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println(name + " , g.n :" + groupNumber);
        }
    }
}
