package u4_1_SimpleClasses.task3_DODELAT;

/**
 * Использование класса Student.
 *
 * В методе main создадим массив из 10 элементов класса Students, затем выведем на экран студентов, у которых все оценки
 * равны 9 или 10
 */
public class StudentsUsage {
    public static void main(String[] args) {
        // Создадим массив
        Student[] arr = new Student[10];
        // Заполним массив
        arr[0] = new Student("Петров А. И.", 21, new int[]{1, 2, 3, 4, 5});
        arr[1] = new Student("Иванов П. Г.", 31, new int[]{9, 10, 9, 10, 9}); // Подходит под условие
        arr[2] = new Student("Сидоров А. В.", 41, new int[]{12, 11});
        arr[3] = new Student("Кузнецов В. И.", 21, new int[]{9, 12, 9, 10, 9}); // Не подходит из-за 2ой оценки
        arr[4] = new Student("Попов Б. Т.", 22, new int[]{9, 9, 9, 9, 9});      // Подходит
        arr[5] = new Student("Смирнов А. И.", 41, new int[]{10, 12, 33, 44, -1});
        arr[6] = new Student("Кудряшов В. Д.", 22, new int[]{2, 10, 3});
        arr[7] = new Student("Матвеев А. А.", 41, new int[]{});
        arr[8] = new Student("Осипов В. А.", 31, new int[]{10, 10, 10, 10, 11}); // Не подходит из-за 5ой оценки
        arr[9] = new Student("Григорьев П. А.", 21, new int[]{10, 10, 10, 10, 10});   // Подходит
        // Пройдем циклом по массиву и выведем на экран студентов с оценками только 9 или 10:
        for (Student student : arr) {
            student.printGrades9And10();
        }
        // Поменяем оценки у некоторых студентов, чтобы они подходили под условие
        arr[3].setGrade(10, 2);
        arr[8].setGrade(9, 5);
        // Выведем студентов с оценками 9 или 10 ещё раз:
        System.out.println("After perfomance correcting: ");
        for (Student student : arr) {
            student.printGrades9And10();
        }
    }
}
