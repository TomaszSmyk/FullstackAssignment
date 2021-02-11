package pl.smyk.tomasz.FullstackAssignment.notehistory;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.smyk.tomasz.FullstackAssignment.note.Note;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class NoteHistoryController {

    @Autowired
    private NoteHistoryService noteHistoryService;


    @GetMapping("/notes/{id}/history")
    public List<Note> getNotesHistory(@PathVariable Long id) {
        log.info("GETting note history with id = " + id);
        return noteHistoryService.getNoteHistory(id);
    }

}
