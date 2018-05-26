package task6;

import java.util.Date;

public class Note {

    private String text;
    private Date date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Note(String text) {
        this.text = text;
    }

    public Note(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    @Override
    public String toString() {
        return text + ((date==null)?"":" created at " + date);
    }
}
