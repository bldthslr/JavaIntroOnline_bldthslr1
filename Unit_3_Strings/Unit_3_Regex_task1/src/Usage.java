/**
 * Использование класса textAnalysis.
 * В методе main задаем некоторый текст, и производим с ним операции согласно условию.
 */
public class Usage {
    public static void main(String[] args) {
        String test = "Повседневная практика показывает, что сложившаяся структура организации требует определения и уточнения модели развития? Задача организации, в особенности же повышение уровня гражданского сознания требует от нас анализа всесторонне сбалансированных нововведений. Таким образом, рамки и место обучения кадров в значительной степени обуславливает создание ключевых компонентов планируемого обновления? Значимость этих проблем настолько очевидна, что социально-экономическое развитие позволяет оценить значение направлений прогрессивного развития. Практический опыт показывает, что постоянное информационно-техническое обеспечение нашей деятельности требует определения и уточнения дальнейших направлений развитая системы массового участия! Разнообразный и богатый опыт консультация с профессионалами из IT представляет собой интересный эксперимент проверки экономической целесообразности принимаемых решений? Практический опыт показывает, что сложившаяся структура организации требует от нас системного анализа форм воздействия.\n" +
               "Практический опыт показывает, что выбранный нами инновационный путь требует от нас анализа форм воздействия. Задача организации, в особенности же выбранный нами инновационный путь напрямую зависит от дальнейших направлений развития проекта. С другой стороны дальнейшее развитие различных форм деятельности обеспечивает широкому кругу специалистов участие в формировании системы обучения кадров, соответствующей насущным потребностям. Дорогие друзья, выбранный нами инновационный путь влечет за собой процесс внедрения и модернизации системы масштабного изменения ряда параметров. Соображения высшего порядка, а также повышение уровня гражданского сознания обеспечивает актуальность соответствующих условий активизации! Разнообразный и богатый опыт дальнейшее развитие различных форм деятельности обеспечивает широкому кругу специалистов участие в формировании существующих финансовых и административных условий.\n" +
                "Соображения высшего порядка, а также консультация с профессионалами из IT требует определения и уточнения дальнейших направлений развитая системы массового участия. Задача организации, в особенности же реализация намеченного плана развития создаёт предпосылки качественно новых шагов для дальнейших направлений развитая системы массового участия! Повседневная практика показывает, что консультация с профессионалами из IT напрямую зависит от системы масштабного изменения ряда параметров. Практический опыт показывает, что рамки и место обучения кадров требует от нас анализа системы масштабного изменения ряда параметров. Разнообразный и богатый опыт рамки и место обучения кадров способствует подготовке и реализации форм воздействия. Разнообразный и богатый опыт новая модель организационной деятельности требует от нас системного анализа экономической целесообразности принимаемых решений? Дорогие друзья, рамки и место обучения кадров требует от нас системного анализа ключевых компонентов планируемого обновления.\n" +
                "Не следует, однако, забывать о том, что консультация с профессионалами из IT способствует подготовке и реализации дальнейших направлений развития проекта. Практический опыт показывает, что консультация с профессионалами из IT позволяет оценить значение дальнейших направлений развитая системы массового участия. Равным образом повышение уровня гражданского сознания представляет собой интересный эксперимент проверки существующих финансовых и административных условий! Практический опыт показывает, что рамки и место обучения кадров влечет за собой процесс внедрения и модернизации позиций, занимаемых участниками в отношении поставленных задач. С другой стороны новая модель организационной деятельности обеспечивает широкому кругу специалистов участие в формировании дальнейших направлений развития проекта! С другой стороны постоянное информационно-техническое обеспечение нашей деятельности требует определения и уточнения соответствующих условий активизации. Разнообразный и богатый опыт реализация намеченного плана развития играет важную роль в формировании форм воздействия.\n" +
                "Не следует, однако, забывать о том, что рамки и место обучения кадров способствует подготовке и реализации дальнейших направлений развитая системы массового участия! С другой стороны выбранный нами инновационный путь требует от нас системного анализа ключевых компонентов планируемого обновления? Соображения высшего порядка, а также постоянное информационно-техническое обеспечение нашей деятельности обеспечивает широкому кругу специалистов участие в формировании направлений прогрессивного развития. Задача организации, в особенности же постоянное информационно-техническое обеспечение нашей деятельности обеспечивает широкому кругу специалистов участие в формировании экономической целесообразности принимаемых решений! Повседневная практика показывает, что выбранный нами инновационный путь играет важную роль в формировании соответствующих условий активизации. Таким образом, начало повседневной работы по формированию позиции обеспечивает актуальность экономической целесообразности принимаемых решений? Повседневная практика показывает, что рамки и место обучения кадров обеспечивает широкому кругу специалистов участие в формировании дальнейших направлений развития проекта!\n" +
                "Задача организации, в особенности же постоянный качественный рост...";
        TextAnalysis analysis = new TextAnalysis(test);
        // Выведем исходный текст в консоль
        System.out.println("Source text:");
        System.out.println(test);
        System.out.println();
        // Выведем текст, отсортированный по абзацам (по количеству предложений в абзацах)
        System.out.println("Sorted paragraphs by number of sentences:");
        System.out.println(analysis.sortParagraphsByNumOfSent());
        System.out.println();
        // Выведем текст с отсортированными (в каждом предложении) словами по длине
        System.out.println("In each sentence, sorted words by length:");
        System.out.println(analysis.sortSentencesByWordLength());
        System.out.println();
        // Выведем текст с отсортированными (в каждом предложении) словами по вхождению символа
        char ch = 'н';
        System.out.println("In each sentence, the words are sorted by the occurrence of the character '" + ch
                + "', otherwise by length:");
        System.out.println(analysis.sortSentByOccurSymbol(ch));
        System.out.println();
    }
}