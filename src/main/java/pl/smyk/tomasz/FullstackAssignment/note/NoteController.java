package pl.smyk.tomasz.FullstackAssignment.note;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping(value = {"/notes", "/"})
    public @ResponseBody List<Note> getAllNotes() {
        log.info("GETting all notes");
        return noteService.getNotes();
    }


    @GetMapping("/notes/{id}")
    public Note getNote(@PathVariable Long id) {
        log.info("GETting note with id = " + id);
        return noteService.findNoteById(id);
    }

    @PostMapping("/newNote")
    public Note createNewNote(@RequestBody Note note) {
        log.info("POSTing new note " + note.toString());
        return noteService.addNote(note);
//        return "redirect:/notes/" + note.getId();
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {
//        noteService.findNoteById(id);
        log.info("UPDATE note with id " + id);
        return noteService.updateNote(note);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        log.info("DELETE note with id " + id);
    }
}
