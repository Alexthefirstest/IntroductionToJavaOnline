package by.epam.tasks.notepad.noteManager.compares;

import by.epam.tasks.notepad.noteManager.Note;

import java.util.Comparator;

public class DataCompare implements Comparator<Note> {


    @Override
    public int compare(Note o1, Note o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
