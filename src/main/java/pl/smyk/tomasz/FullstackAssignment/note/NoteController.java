package pl.smyk.tomasz.FullstackAssignment.note;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        log.info("GETting all notes");
        return noteService.getNotes();
    }

    @GetMapping("/notes/{id}")
    public Note getNote(@PathVariable String id) {
        log.info("GETting note with id = " + id);
        return noteService.findNoteById(id);
    }

    @PostMapping("newNote")
    public void createNewNote(@RequestBody Note note) {
        noteService.addNote(note);
        log.info("POSTing new note " + note.toString());
    }

    @PutMapping("/notes/{id}")
    public void updateNote(@PathVariable String id) {
        noteService.findNoteById(id);
        log.info("UPDATE note with id " + id);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable String id) {
        noteService.deleteNote(id);
        log.info("DELETE note with id " + id);
    }
}
