/*
 *
 * класс включающий основной набор методов для использования из пользователььского интерфейса
 *
 *
 */

package by.epam.tasks.notepad.noteManager;

import by.epam.tasks.notepad.noteManager.compares.BodyCompare;
import by.epam.tasks.notepad.noteManager.compares.DataCompare;
import by.epam.tasks.notepad.noteManager.compares.EmailCompare;
import by.epam.tasks.notepad.noteManager.compares.HeadCompares;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NotesManager implements Serializable {

    public NotesManager() {

    }

    ArrayList<Note> notes = new ArrayList<>();

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public String interString() {

        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public String interHead() {

        System.out.print("Введите заголовок: ");
        return interString();
    }

    public String interBody() {

        System.out.print("Введите текст заметки: ");
        return interString();
    }

    public String interEmail() {

        System.out.print("Введите email: ");
        return interString();
    }

    public String interData() {

        System.out.print("Введите дату в формате: день.месяс.год_часы:минуты \n" +
                "допустимо использовать любой параметр по отдельности, а так же комбинации: ");

        return interString();
    }

    public void addNoteUsingHeadBodyEmail() {

        System.out.println("поля можно оставить пустыми и записать позже: ");

        boolean ok = false;
        String head = interHead();
        String body = interBody();

        while (!ok) {
            String email = interEmail();

            try {
                Note note = new Note(head, body, email);
                notes.add(note);
                System.out.println("\nзаметка успешно создана:\n\n" + note.toString());
                ok = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("email введен неверно, это поле можно оставить пустым");
            }
        }

    }

    /*печать заметок с выводом только даты и названия*/
    static public void printNotes(ArrayList<Note> notes) {

        System.out.println();

        for (int i = 0; i < notes.size(); i++) {

            System.out.println("№" + (i + 1) + ". " + notes.get(i).getDate() + " " + notes.get(i).getHead() +
                    "\n" + notes.get(i).getEmail());
            System.out.println();
        }

    }

    /*печать полных заметок*/
    static public void printFullNotes(ArrayList<Note> notes) {

        System.out.println();

        for (int i = 0; i < notes.size(); i++) {
            System.out.println("№" + (i + 1) + ". " + notes.get(i).toString());
            System.out.println();
        }

    }

    public ArrayList<Note> findNote() {

        ArrayList<Note> foughtNotes = null;

        Scanner in = new Scanner(System.in);
        int choiceOutside = 0;

        while (choiceOutside != 6) {

            System.out.print("\n1 - найти по теме, 2 - найти по содержанию, 3 - найти по дате, 4 - найти по email," +
                    "\n5 - найти по теме и дате,  6 - выход: ");

            do {

                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choiceOutside = in.nextInt();

                if (choiceOutside < 1 || choiceOutside > 6) {
                    System.out.print("введите число из предложенных выше: ");
                }

            } while (choiceOutside < 1 || choiceOutside > 6);


            switch (choiceOutside) {

                case 1:
                    foughtNotes = Searches.findByHead(notes, interHead());
                    printNotes(foughtNotes);
                    break;

                case 2:
                    foughtNotes = Searches.findByBody(notes, interBody());
                    printFullNotes(foughtNotes);
                    break;
                case 3:
                    foughtNotes = Searches.findByData(notes, interData());
                    printFullNotes(foughtNotes);
                    break;
                case 4:
                    foughtNotes = Searches.findByEmail(notes, interEmail());
                    printFullNotes(foughtNotes);
                    break;
                case 5:
                    foughtNotes = Searches.findByHead(Searches.findByData(notes, interData()), interHead());
                    printFullNotes(foughtNotes);
                    break;
            }
        }
        return foughtNotes;
    }

    public ArrayList<Note> sortNotes() {
        return sortNotes(notes);
    }

    public ArrayList<Note> sortNotes(ArrayList<Note> notes) {

        ArrayList<Note> printedNotes = new ArrayList<>(notes);

        Scanner in = new Scanner(System.in);
        int choiceOutside = 0;

        while (choiceOutside != 5) {

            System.out.print("\n1 - сортировать по теме, 2 - сортировать по содержанию, \n" +
                    "3 - сотртировать по дате, 4 - сортировать по email," + " 5 - выход: ");


            do {

                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choiceOutside = in.nextInt();

                if (choiceOutside < 1 || choiceOutside > 5) {
                    System.out.print("введите число из предложенных выше: ");
                }

            } while (choiceOutside < 1 || choiceOutside > 5);


            switch (choiceOutside) {

                case 1:
                    Collections.sort(notes, new HeadCompares());
                    printNotes(notes);
                    printedNotes = notes;
                    break;

                case 2:
                    Collections.sort(notes, new BodyCompare());
                    printFullNotes(notes);
                    printedNotes = notes;
                    break;
                case 3:
                    Collections.sort(notes, new DataCompare());
                    printNotes(notes);
                    printedNotes = notes;
                    break;
                case 4:
                    Collections.sort(notes, new EmailCompare());
                    printNotes(notes);
                    printedNotes = notes;
                    break;
            }

        }
        return printedNotes;

    }

    /*метод для изменения полей конкретной заметки*/
    public void changeNote(Note note) {

        Scanner in = new Scanner(System.in);
        int choiceOutside = 0;

        while (choiceOutside != 5) {

            System.out.println("\nвыбранная заметка: " + note.toString());

            System.out.print("\n1 - изменить тему, 2 - изменить сообщение, \n" +
                    "3 - дополнить сообщение, 4 - изменить email, 5 - выход: ");


            do {

                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choiceOutside = in.nextInt();

                if (choiceOutside < 1 || choiceOutside > 5) {
                    System.out.print("введите число из предложенных выше: ");
                }

            } while (choiceOutside < 1 || choiceOutside > 5);


            switch (choiceOutside) {

                case 1:
                    note.setHead(interHead());
                    break;
                case 2:
                    note.setBody(interBody());
                    break;
                case 3:
                    note.addToBody(interBody());
                    break;
                case 4:

                    try {
                        note.setEmail(interEmail());
                    } catch (IllegalArgumentException ex) {
                        System.out.println("email введен неверно");
                    }

                    break;
            }

            System.out.println("заметка изменена.");
        }

    }

    public void saveProgress() {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(".\\src\\by\\epam\\tasks\\notepad\\saves\\notesManager.ser"));
            oos.writeObject(this);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
