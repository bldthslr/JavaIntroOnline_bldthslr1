package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий логику работы с текстовым файлом. Содержит поле "файл" типа java.io.File
 * и "содержимое" - поле String.
 */
public class FileChanger {
    private File file;

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
     }


    // Считывает текст из файла.
     public String read() {
        try {
            StringBuilder res = new StringBuilder();
            FileReader fr = new FileReader(file);
            int c;
            while ((c = fr.read()) != -1) {
                res.append((char)c);
            }
            return res.toString();
        }
        catch (IOException e) {
            System.out.println("Can nor read file" + file.getName());
            return null;
        }
     }

    // Удаляет файл
     public boolean delete() {
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
            return true;
        }
        catch (IOException e) {
            System.out.println("writing to the file" + file.getName() + " is not possible");
            return false;
        }
     }

    // Обновляет файл
    public boolean refresh(String newContent) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.append(newContent);
            fw.close();
            return true;
        }
        catch (IOException e) {
            System.out.println("writing to the file" + file.getName() + " is not possible");
            return false;
        }
    }
}
