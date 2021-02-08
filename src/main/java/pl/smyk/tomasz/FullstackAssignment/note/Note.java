package pl.smyk.tomasz.FullstackAssignment.note;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
/*
TODO
check - does this final works good when modifying notes
 */
@Data
@RequiredArgsConstructor
public class Note {
    @NotNull
    private final String title;
    @NotNull
    private final String content;
    private LocalDate created = LocalDate.now();
    private LocalDate modified = LocalDate.now();
}
