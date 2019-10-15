package by.epam.tasks.notepad.noteManager;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Searches {

    static public ArrayList<Note> findByHead(ArrayList<Note> notes, String head) {

        ArrayList<Note> resultNotes = new ArrayList<>();

        head = head.toLowerCase().replaceAll("\\s+", "");
        head = ".*" + head + ".*";

        for (Note note : notes) {

            if (Pattern.matches(head, note.getHead().toLowerCase().replaceAll("\\s+", ""))) {
                resultNotes.add(note);
            }

        }
        return resultNotes;
    }

    static public ArrayList<Note> findByBody(ArrayList<Note> notes, String body) {

        ArrayList<Note> resultNotes = new ArrayList<>();

        body = body.toLowerCase().replaceAll("\\s+", "");
        body = ".*" + body + ".*";

        for (Note note : notes) {

            if (Pattern.matches(body, note.getBody().toLowerCase())) {
                resultNotes.add(note);
            }

        }
        return resultNotes;
    }

    static public ArrayList<Note> findByEmail(ArrayList<Note> notes, String email) {

        ArrayList<Note> resultNotes = new ArrayList<>();

        email = email.toLowerCase().replaceAll("\\s+", "");
        email = ".*" + email + ".*";

        for (Note note : notes) {

            if (Pattern.matches(email, note.getEmail().toLowerCase().replaceAll("\\s+", ""))) {
                resultNotes.add(note);
            }

        }
        return resultNotes;
    }

    static public ArrayList<Note> findByData(ArrayList<Note> notes, String data) {

        ArrayList<Note> resultNotes = new ArrayList<>();

        data = data.replaceAll("\\s+", "");
        String[] dataArr = data.split("_");

        if (dataArr.length == 2) {
            data = ".*" + dataArr[0] + ".*" + dataArr[1] + ".*";//возможность найти как 10.14.2019_23:34 так и 10.14_23
        } else {
            data = ".*" + data + ".*";
        }

        for (Note note : notes) {

            if (Pattern.matches(data, note.getDate())) {
                resultNotes.add(note);
            }

        }
        return resultNotes;
    }

}