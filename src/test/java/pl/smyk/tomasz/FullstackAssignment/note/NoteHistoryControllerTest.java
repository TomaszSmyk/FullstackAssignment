package pl.smyk.tomasz.FullstackAssignment.note;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.smyk.tomasz.FullstackAssignment.notehistory.NoteHistoryService;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NoteHistoryControllerTest {

    @MockBean
    private NoteHistoryService noteHistoryService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void  testGetNotesHistorySuccess() throws Exception{
        Note note1 = new Note(1L,"Title 1", "Content 1");
        Note note2 = new Note(1L,"Title 1 EDIT", "Content 1 EDIT");
        doReturn(Arrays.asList(note1, note2)).when(noteHistoryService).getNoteHistory(anyLong());

        this.mockMvc.perform(get("/notes/1/history"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("[0].id", is(1)))
                .andExpect(jsonPath("[0].title", is("Title 1")))
                .andExpect(jsonPath("[0].content", is("Content 1")))
                .andExpect(jsonPath("[1].id", is(1)))
                .andExpect(jsonPath("[1].title", is("Title 1 EDIT")))
                .andExpect(jsonPath("[1].content", is("Content 1 EDIT")));
    }
}
