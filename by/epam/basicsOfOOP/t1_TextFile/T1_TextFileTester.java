/*
 *
 *   Basics of OOP
 *
 *
 *
 *
 *  Задача 1.
 * Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 *
 * - psvm only
 *
 */

package by.epam.basicsOfOOP.t1_TextFile;

public class T1_TextFileTester {

    public static void main(String[] args) {

        TextFile tf = TextFile.createFile();
        tf.printAll();

        tf.renameFile("file1");

        tf.printBody();

        tf.addToBody("Hello ");
        tf.addToBody("inner");
        tf.printBody();

        tf.addToBody(" classes");
        tf.printBody();

        System.out.println();
        tf.printAll();

        tf = TextFile.deleteFile(tf);
        System.out.println(tf);

    }

}


