package pl.smyk.tomasz.FullstackAssignment.note;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
TODO
check - does this final works good when modifying notes
 */
@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    private String created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    private String modified = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    public Note() {
    }

    public Note(@NotNull Long id, @NotNull String title, @NotNull String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
