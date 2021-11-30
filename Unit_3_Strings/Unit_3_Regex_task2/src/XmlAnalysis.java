import java.util.ArrayList;
import java.util.List;

/**
 * "Дана строка, содержащая следующий текст (xml-документ):
 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
 * тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
 * нельзя."
 *
 * Данный класс реализует анализатор xml-документа.
 * В данном классе используется внутренний класс для описания узлов (описывает содержимое тега и его тип);
 * В конструкторе вызывается приватный метод fillTagList(), который парсит xml-документ и заполняет массив тегов.
 * Использование метода next() возвращает информацию о следующем узле документа в виде String. Если узлы закончились,
 * то возвращает строку с информацией, что узлы закончились.
 *
 * В данном решении не обрабатываются исключения, и возможны непредсказуемые ошибки, если в качестве текста использовать
 * "невалидный" xml (или другой случайный текст).
 */
public class XmlAnalysis {
    private String xml;
    private List<Node> nodeList = new ArrayList<>();
    int curIndex = 0;

    // Конструктор
    public XmlAnalysis (String xml) {
        this.xml = xml;
        fillTagList();
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getXml() {
        return xml;
    }

    // Внутренний класс для описания тега
    private class Node {
        String tag;
        String type;

        // Конструктор
        private Node(String tag, String type) {
            this.tag = tag;
            this.type = type;
        }
    }

    // Возвращает в виде String информацию о следующем узле xml-документа. Возвращает "XML ENDED", если узлов больше нет
    public String next() {
        if (curIndex < nodeList.size()) {
            String res = "Tag: |" + nodeList.get(curIndex).tag + "|; Type = |" + nodeList.get(curIndex).type + "|.";
            curIndex++;
            return res;
        }
        else {
            return "XML ENDED";
        }
    }

    /**
     * "Парсит" XML-документ, и заполняет массив nodeList объектами Tag.
     */
    private void fillTagList() {
        StringBuilder tmp;
        for (int i = 0; i < xml.length(); i++) {
            // Если открывающий тег
            if (xml.charAt(i) == '<') {
                i++;
                // Если следующий элемент == '/', то это закрывающий тег
                if (xml.charAt(i) == '/') {
                    tmp = new StringBuilder("");
                    while (xml.charAt(i-1) != '>') {
                        tmp.append(xml.charAt(i));
                        i++;
                    }
                    nodeList.add(new Node(tmp.substring(0, tmp.length() - 1), "closing tag"));
                    i--;
                }
                // Если нет, то это может быть открывающий тег или тег без тела
                else {
                    tmp = new StringBuilder("");
                    while (xml.charAt(i-1) != '>') {
                        tmp.append(xml.charAt(i));
                        i++;
                    }
                    // Если в конце тега (перед '>') стоял символ '/', то это тег без тела
                    if (tmp.charAt(tmp.length() - 2) == '/') {
                        nodeList.add(new Node(tmp.substring(0, tmp.length() - 1), "empty tag"));
                    }
                    else {
                        nodeList.add(new Node(tmp.substring(0, tmp.length() - 1), "opening tag"));
                    }
                    i--;
                }
            }
            // Если не открывающий тег, то это содержимое тега
            else {
                // Если предыдущий тег был открывающим, то это содержимое тега
                if (nodeList.get(nodeList.size() - 1).type.equals("opening tag")) {
                    tmp = new StringBuilder("");
                    while (xml.charAt(i) != '<') {
                        tmp.append(xml.charAt(i));
                        i++;
                    }
                    // Проверка, если в теле тега только пробелы и переносы строки, то это не тело тега
                    if (!tmp.toString().replaceAll(" ", "").replaceAll("\n","").equals("")) {
                        nodeList.add(new Node(tmp.toString(), "content"));
                    }
                    i--;
                }
            }
        }
    }


}
