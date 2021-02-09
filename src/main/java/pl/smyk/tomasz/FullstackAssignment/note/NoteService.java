package pl.smyk.tomasz.FullstackAssignment.note;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
//    private List<Note> notes = new ArrayList<>( Arrays.asList(
//            new Note("1","Title 1", "Content 1"),
//            new Note("2","Title 2", "Content 2"),
//            new Note("3","Title 3", "Content 3"),
//            new Note("4","Title 4", "Content 4")
//    ));

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        noteRepository.findAll().forEach(notes::add);
        return notes;
    }

    public Note findNoteById(Long id) {
//        return notes.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        return noteRepository.findById(id).get();
    }

    public void addNote(Note note) {
        noteRepository.save(note);
    }

    public void deleteNote(Long id) {
//        notes.remove(notes.stream().filter(x -> x.getId().equals(id)).findFirst().get());
        noteRepository.deleteById(id);
    }

    public void updateNote(Note note) {
        noteRepository.save(note);
    }
}
