import java.util.Date;
import task6.Note;
import task6.NotePad;

public class Main {

    public static void main(String[] args) {
        NotePad notePad = new NotePad(5);
        notePad.addNote(new Note("first note", new Date()));
        notePad.addNote(new Note("second note"));
        notePad.addNote(new Note("hello", new Date()));
        notePad.showNotes();
        notePad.removeNote(1);
        notePad.showNotes();
        notePad.addNote(new Note("second note"));
        notePad.showNotes();
        notePad.changeNote(2, new Note("hi", new Date()));
        notePad.showNotes();
    }

}
