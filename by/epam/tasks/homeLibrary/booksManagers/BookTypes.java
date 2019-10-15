package by.epam.tasks.homeLibrary.booksManagers;

public enum BookTypes {

    ЭЛЕКТРОННЫЙ,
    БУМАЖНЫЙ;

    static public void printAvailableTypes() {

        System.out.println("Варианты книг: ");

        for (BookTypes type : values()) {
            System.out.println(type.name().toLowerCase());
        }

    }
}
