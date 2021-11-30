package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий логику работы с текстовым файлом. Содержит поле "файл" типа java.io.File
 * и "содержимое" - список текстовых строк.
 */
public class FileChanger {
    private File file;
    private List<String> content;

    // Конструктор, принимающий только имя файла
    public FileChanger(String name) {
        file = new File(name);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Cant find or create file " + name);
            }
        }
        content = new ArrayList<>();
        read();
    }

    // Конструктор с файлом и директорией
     public FileChanger(String dir, String name) {
         file = new File(dir, name);
         if (!file.exists()) {
             try {
                 File dirct = new File(file.getAbsolutePath());
                 if (!dirct.exists()) {
                     try {
                         dirct.createNewFile();
                     } catch (IOException e) {
                         System.out.println("Cant find or create file " + name);
                     }
                 }
                 file.createNewFile();
             }
             catch (Exception e) {
                 System.out.println("Cant find or create file " + name);
             }
         }
         content = new ArrayList<>();
         read();
     }

     public List<String> getContent() {
        read();
        return content;
     }

    // Считывает текст из файла, помещает его в поле content.
     private boolean read() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line;
            content.clear();
            while ((line = bf.readLine()) != null) {
                content.add(line);
            }
            return true;
        }
        catch (IOException e) {
            System.out.println("Can nor read file" + file.getName());
            return false;
        }
     }

    // Удаляет файл
     public boolean delete() {
        content.clear();
         return file.delete();
     }

    // Обновляет файл
     public boolean refresh(List<String> newContent) {
        try {
            FileWriter fw = new FileWriter(file);
            for (String line : newContent) {
                fw.append(line).append(System.lineSeparator());
            }
            fw.close();
            content = newContent;
            return true;
        }
        catch (IOException e) {
            System.out.println("writing to the file" + file.getName() + " is not possible");
            return false;
        }
     }


}
