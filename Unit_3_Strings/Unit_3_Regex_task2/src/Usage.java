import java.util.Scanner;

/**
 * Использование класса - анализатора XmlAnalysis.
 * В качестве анализируемого текста использовался пример из условия.
 */
public class Usage {
    public static void main(String[] args) {
        String xml = """
                <notes>
                 <note id = "1">
                  <to>Вася</to>
                  <from>Света</from>
                  <heading>Напоминание</heading>
                  <body>Позвони мне завтра!</body>
                 </note>
                 <note id = "2">
                  <to>Петя</to>
                  <from>Маша</from>
                  <heading>Важное напоминание</heading>
                  <body/>
                  </note>
                </notes>""";
        // Создаем анализатор
        XmlAnalysis xmlAnalysis = new XmlAnalysis(xml);
        System.out.println("The program sequentially returns the nodes of the XML document! ");
        System.out.println("Press Enter to see the next node, type \"e\" to exit!");
        Scanner in = new Scanner(System.in);
        // При нажатии пробела, получим следующий узел. При вводе 'e' - выход.
        while (!in.nextLine().equals("e")) {
            System.out.println(xmlAnalysis.next());
        }
    }
}
