package pl.smyk.tomasz.FullstackAssignment.note;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
