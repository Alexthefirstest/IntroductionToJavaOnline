package by.epam.tasks.notepad.noteManager.compares;

import by.epam.tasks.notepad.noteManager.Note;

import java.util.Comparator;

public class BodyCompare  implements Comparator<Note> {


    @Override
    public int compare(Note o1, Note o2) {
        return o1.getBody().compareTo(o2.getBody());
    }

}
