# Задача 4.
Создать консольное приложение, удовлетворяющее следующим требованиям:
* Приложение должно быть объектно-, а не процедурно-ориентированным.
* Каждый класс должен иметь отражающее смысл название и информативный состав.
* Наследование должно применяться только тогда, когда это имеет смысл.
* При кодировании должны быть использованы соглашения об оформлении кода java code convention.
* Классы должны быть грамотно разложены по пакетам.
* Консольное меню должно быть минимальным.
* Для хранения данных можно использовать файлы.

**Дракон и его сокровища**. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ на заданную сумму.

___

### Информация
* Исполняемый класс: **Main.java**;
* IDE: **IntelliJ IDEA 2021.2 Community Edition**;
* JDK: **15.0.1**;
* Автор: **Пригоряну Виктор**.

---
### Решение
Данное консольное приложение должно обрабатывать информацию о 100 сокровищах дракона, а так же реализовывать логику просмотра и выбора сокровищ.
Для хранения информации о сокровищах используем файл **Dragon.txt**. 

Для реализации данного приложения был использован паттерн LA, и все классы были разделены по пакетам:
* **data** : Слой данных, содержит текстовые файлы с данными.
* **dao** : Слой доступа к данным. Включает в себя классы *DragonDAO*, *FileChanger*, *Generator*.
* **bean** : Слой сущностей. В данном приложение две сущности - сокровище (*Treasure*), и дракон (*Dragon*). Дракон в своей пещере содержит сокровища, и взаимодействует с пользователем (в классе *Dragon* реализована логика просмотра и выбора сокровищ).
* **aservices**: Слой взаимодействия с клиентом. Включает в себя консольное меню *ConsoleMenu*, и исполняемый класс *Main*.

Если файл **Dragon.txt** поврежден или не создан, то необходимо "сгенерировать" сокровища. За это отвечает класс Generator

---

### Генерация сокровищ
Генерация сокровищ происходит в 5 этапов:
1) Считывается информация из файла **types.txt** о типах сокровищ, и составляется полный список возможных сокровищ с их вероятностью;
2) Считывается информация из файлов ***_rarity.txt**, о различных модификаторах для сокровищ. Оружие, например, может быть поврежденным или утяжеленным, а ювелирные изделия могут быть украшены драгоценными камнями. Составляется полный список модификаций для каждого типа.
3) Для всех списков просчитывается вероятность получения конкретной строки (предмета или модификации).
4) Благодаря функции **Math.random()** случайно выбирается предмет. Если к нему можно применить модификацию, так же случайно применяется модификация. Формируется строка такого типа, как и в **Dragon.txt**;
5) В качестве работы своего основного публичного метода **generate(int number)** генерируется список строк с сокровищами.

Нужно отметить, что генерируется "содержимое" файла **Dragon.txt**, однако за запись в сам файл и извлечение данных отвечает класс **DragonDAO**. 

