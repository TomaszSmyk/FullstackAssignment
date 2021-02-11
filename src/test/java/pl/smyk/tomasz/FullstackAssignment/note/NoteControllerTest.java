package pl.smyk.tomasz.FullstackAssignment.note;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTest {

    @MockBean
    private NoteService noteService;

    //this will load only web layer, not whole app context
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

    @Test
    void testCreateNewNoteSuccess() throws Exception{
        Note note1 = new Note(1L,"Title 1", "Content 1");
        when(noteService.addNote(ArgumentMatchers.any())).thenReturn(note1);

        this.mockMvc
                .perform(post("/newNote")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1, \"title\":\"Title 1\", \"content\":\"Content 1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Title 1")))
                .andExpect(jsonPath("$.content", is("Content 1")));

        ArgumentCaptor<Note> anyNote = ArgumentCaptor.forClass(Note.class);
        verify(noteService).addNote(anyNote.capture());
        assertThat(anyNote.getValue().getTitle()).isEqualTo("Title 1");
        assertThat(anyNote.getValue().getContent()).isEqualTo("Content 1");
    }

    @Test
    void testUpdateNoteSuccess() throws Exception{
        Note note1 = new Note(1L,"Updated Title 1", "Updated Content 1");
        when(noteService.updateNote(ArgumentMatchers.any())).thenReturn(note1);

        this.mockMvc
                .perform(put("/notes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1, \"title\":\"Title 1\", \"content\":\"Content 1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Updated Title 1")))
                .andExpect(jsonPath("$.content", is("Updated Content 1")));

        ArgumentCaptor<Note> anyNote = ArgumentCaptor.forClass(Note.class);
        verify(noteService).updateNote(anyNote.capture());
        assertThat(anyNote.getValue().getTitle()).isEqualTo("Title 1");
        assertThat(anyNote.getValue().getContent()).isEqualTo("Content 1");
    }

    @Test
    void testDeleteNoteSuccess() throws Exception{
        this.mockMvc
                .perform(delete("/notes/1"))
                .andExpect(status().isOk());
    }
}
