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

    public List<Note> getNoteHistory(Long id) {
//        AuditReader auditReader = AuditReaderFactory.get();
//        return noteRepository.findRevisions(id).getContent();
        List<Note> noteHistory = new ArrayList<>();

        noteRepository.findRevisions(id).get().forEach(x -> noteHistory.add(x.getEntity()));

        return noteHistory;
    }

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Note updateNote(Note note) {
        //todo block 'created' column changes
        return noteRepository.save(note);
    }
}
