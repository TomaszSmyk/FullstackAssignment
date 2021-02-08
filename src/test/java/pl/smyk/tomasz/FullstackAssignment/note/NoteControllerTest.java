package pl.smyk.tomasz.FullstackAssignment.note;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTest {

    @MockBean
    private NoteService noteService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllNotesSuccess() throws Exception {

        Note note1 = new Note(1L,"Title 1", "Content 1");
        Note note2 = new Note(2L,"Title 2", "Content 2");
        doReturn(Arrays.asList(note1, note2)).when(noteService).getNotes();


        this.mockMvc.perform(get("/notes"))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("[0].id", is(1)))
                .andExpect(jsonPath("[0].title", is("Title 1")))
                .andExpect(jsonPath("[0].content", is("Content 1")))
                .andExpect(jsonPath("[1].id", is(2)))
                .andExpect(jsonPath("[1].title", is("Title 2")))
                .andExpect(jsonPath("[1].content", is("Content 2")));

    }

    @Test
    public void testGetNoteSuccess() throws Exception{
        Note note1 = new Note(1L,"Title 1", "Content 1");
        doReturn(note1).when(noteService).findNoteById(anyLong());

        this.mockMvc.perform(get("/notes/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString("1")))
                .andExpect(content().string(containsString("Title 1")))
                .andExpect(content().string(containsString("Content 1")));
    }

}
