package pl.smyk.tomasz.FullstackAssignment.note;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
TODO
check - does this final works good when modifying notes
 */
@Data
@RequiredArgsConstructor
public class Note {
    @NotNull
    private final String id;
    @NotNull
    private final String title;
    @NotNull
    private final String content;
    private String created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    private String modified = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
}
