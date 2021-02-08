package pl.smyk.tomasz.FullstackAssignment.note;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class NoteService {
    private List<Note> notes = Arrays.asList(
            new Note("Title 1", "Content 1"),
            new Note("Title 2", "Content 2"),
            new Note("Title 3", "Content 3"),
            new Note("Title 4", "Content 4")
    );
}
