package pl.smyk.tomasz.FullstackAssignment.note;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class NoteService {
    private List<Note> notes = new ArrayList<>( Arrays.asList(
            new Note("1","Title 1", "Content 1"),
            new Note("2","Title 2", "Content 2"),
            new Note("3","Title 3", "Content 3"),
            new Note("4","Title 4", "Content 4")
    ));

    public List<Note> getNotes() {
        return notes;
    }

    public Note findNoteById(String id) {
        return notes.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(String id) {
        notes.remove(notes.stream().filter(x -> x.getId().equals(id)).findFirst().get());
    }
}
