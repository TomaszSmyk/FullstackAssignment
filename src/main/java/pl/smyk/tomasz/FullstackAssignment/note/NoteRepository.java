package pl.smyk.tomasz.FullstackAssignment.note;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;


public interface NoteRepository extends CrudRepository<Note, Long>, RevisionRepository<Note, Long, Integer> {

}
