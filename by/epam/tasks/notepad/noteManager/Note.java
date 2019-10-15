package by.epam.tasks.notepad.noteManager;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Note implements Serializable {

    Note(String head, String body, String email) {
        this.head = head;
        this.body = body;
        setEmail(email);
        date = new SimpleDateFormat("MM.dd.yyyy_HH:mm").format(new Date());
    }

    private String head;
    private String body;
    private String email;
    private String date;

    public String getDate() {
        return date;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void addToBody(String newText) {
        this.body = this.body + " " + newText;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {

        if (!Pattern.matches(".+@.+\\..+", email) && !email.equals("")) {
            throw new IllegalArgumentException("wrong email");
        }

        this.email = email;
    }

    @Override
    public java.lang.String toString() {
        return date + " " + email + "\n" + head + "\n\n" + body;
    }
}
