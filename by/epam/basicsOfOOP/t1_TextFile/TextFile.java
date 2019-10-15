/*
 *
 * Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 *
 *
 */

package by.epam.basicsOfOOP.t1_TextFile;

class TextFile {

    private TextFile(String name, String directory) {

        file = new File();
        this.directory = new Directory();

        file.name = name;
        this.directory.directory = directory;
        file.body = "";
    }


    private File file;
    private Directory directory;


    public static TextFile createFile(String name, String directory) {
        return new TextFile(name, directory);
    }

    public static TextFile createFile(String name) {
        return new TextFile(name, "");
    }

    public static TextFile createFile() {
        return new TextFile("", "");
    }


    public static TextFile deleteFile(TextFile tf) {
        tf = null;
        return tf;
    }

    public void renameFile(String newName) {
        file.name = newName;
    }

    public void addToBody(String newText) {
        file.body += newText;
    }

    public void resetDirectory(String newdirectory) {
        directory.directory += newdirectory;
    }

    public void printBody() {
        System.out.println(file.body);
    }

    public void printAll() {

        System.out.print("File name");

        if (!file.name.isEmpty()) {
            System.out.println(": " + file.name);
        } else {
            System.out.println(" wasn't set");
        }

        System.out.print("Directory");

        if (!directory.directory.isEmpty()) {
            System.out.println(": " + directory.directory);
        } else {
            System.out.println(" wasn't set");
        }

        System.out.println();
        System.out.println(file.body);
    }


    class File {

        String name;
        String body;
    }


    class Directory {

        String directory;
    }


}
