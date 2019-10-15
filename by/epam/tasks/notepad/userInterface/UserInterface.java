/*
 *
 * пользовательский интерфейс
 *
 *
 */

package by.epam.tasks.notepad.userInterface;

import by.epam.tasks.notepad.noteManager.LoadSaves;
import by.epam.tasks.notepad.noteManager.Note;
import by.epam.tasks.notepad.noteManager.NotesManager;

import java.util.ArrayList;
import java.util.Scanner;

public class userInterface {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        NotesManager notesManager = LoadSaves.loadSaves();

        /*поля дле возможности работы с последним выведенным на экран списком заметок*/
        ArrayList<Note> printedNotes = notesManager.getNotes();

        //поле для работы с последними найденным с поммощью метода поиска заметками
        ArrayList<Note> foughtNotes = notesManager.getNotes();

        int choiceOutside = 0;

        while (choiceOutside != 7) {

            System.out.print("\n1 - добавить заметку, 2 - найти заметку, 3 - отсортировать заметки, " +
                    "4 - отсортировать найденные заметки,\n 5 - распечатать все заметки, " +
                    "6 - изменить заметку, 7 - выход: ");

            do {

                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choiceOutside = in.nextInt();

                if (choiceOutside < 1 || choiceOutside > 7) {
                    System.out.print("введите число из предложенных выше: ");
                }

            } while (choiceOutside < 1 || choiceOutside > 7);

            switch (choiceOutside) {

                case 1:
                    notesManager.addNoteUsingHeadBodyEmail();
                    printedNotes = notesManager.getNotes();
                    break;

                case 2:
                    foughtNotes = notesManager.findNote();
                    printedNotes = foughtNotes;
                    break;

                case 3:
                    printedNotes = notesManager.sortNotes();
                    break;
                case 4:

                    if (foughtNotes != null) {
                        printedNotes = notesManager.sortNotes(foughtNotes);
                    } else {
                        System.out.println("заметки не выбраны");
                    }

                    break;

                case 5:
                    notesManager.printFullNotes(notesManager.getNotes());
                    printedNotes = notesManager.getNotes();
                    break;

                case 6:

                    int number;


                    if (printedNotes.size() == 0) {
                        System.out.println("заметки не выбраны");
                    } else {

                        System.out.println("Введите номер заметки: ");

                        do {
                            while (!in.hasNextInt()) {
                                System.out.println("введите целое число: ");
                                in.next();
                            }
                            number = in.nextInt();
                            number--;

                            if (number < 0 || number >= printedNotes.size()) {
                                System.out.print("неверно введен номер: ");
                            }

                        } while (number < 0 || number >= printedNotes.size());

                        notesManager.changeNote(printedNotes.get(number));
                    }

            }//switch

        }
        notesManager.saveProgress();

    }
}