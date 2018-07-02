public class NotePad {

    private Note[] notes;

    public NotePad(int size) {
        this.notes = new Note[size];
    }

    public boolean addNote(Note note){
        int pointer = findFreePlace();
        if(pointer!=-1)
            notes[pointer] = note;
        else return false;
        return true;
    }

    public boolean removeNote(int index){
        if(Math.abs(index) < notes.length && notes[index]!=null)
            notes[index] = null;
        else return false;
        return true;
    }

    public boolean changeNote(int index, Note note){
        if(Math.abs(index) < notes.length && notes[index]!=null)
            notes[index] = note;
        else return false;
        return true;
    }

    public void showNotes(){
        for (Note note: notes) {
            if(note!=null) System.out.println(note);
        }
    }

    /**
     * Функция ищет свободную ячейку в блокноте
     * @return Если успешно возвращает индект свободного элемента массива,
     * в случае, если такого элемента нет, вернет -1
     */
    private int findFreePlace(){
        for(int i = 0; i < notes.length; i++){
            if(notes[i]==null)return i;
        }
        return -1;
    }
}