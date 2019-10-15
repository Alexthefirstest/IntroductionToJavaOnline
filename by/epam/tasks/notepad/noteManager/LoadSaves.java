package by.epam.tasks.notepad.noteManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class LoadSaves {

    static public NotesManager loadSaves() {

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(".\\src\\by\\epam\\tasks\\notepad\\saves\\notesManager.ser"));
            NotesManager notesManager = (NotesManager) ois.readObject();
            ois.close();
            return notesManager;

        } catch (FileNotFoundException ex) {
            System.out.println("сохранения не найдены");
            return new NotesManager();
        } catch (Exception ex) {
            System.out.println("another exception");
            ex.printStackTrace();
        }

        return new NotesManager();
    }

}
