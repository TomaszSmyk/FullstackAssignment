package pl.smyk.tomasz.FullstackAssignment.note;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/notes")
    public List<Note> getAllNotes() {
        log.info("Getting all notes");
        return noteService.getNotes();
    }

    @RequestMapping("/notes/{id}")
    public Note getNote(@PathVariable String id) {
        log.info("Getting note with id = " + id);
        return noteService.getNoteById(id);
    }
}
