package pl.smyk.tomasz.FullstackAssignment.notehistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.smyk.tomasz.FullstackAssignment.note.Note;
import pl.smyk.tomasz.FullstackAssignment.note.NoteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteHistoryService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNoteHistory(Long id) {
        List<Note> noteHistory = new ArrayList<>();

        noteRepository.findRevisions(id).get().forEach(x -> noteHistory.add(x.getEntity()));

        return noteHistory;
    }
}
