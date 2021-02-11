package pl.smyk.tomasz.FullstackAssignment.note;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        noteRepository.findAll().forEach(notes::add);
        return notes;
    }

    public Note findNoteById(Long id) {
        return noteRepository.findById(id).get();
    }



    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }
}
