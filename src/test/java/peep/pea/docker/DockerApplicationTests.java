package peep.pea.docker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import peep.pea.docker.controller.BookController;
import peep.pea.docker.model.Book;
import peep.pea.docker.repository.BookRepository;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class DockerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    private static final Long expectedBookId = 1L;
    private static final String expectedBookTitle = "Book One";
    private static final String expectedBookAuthor = "Author One";

    @Test
    public void testGetAllBooks() throws Exception {
        Book book = new Book(expectedBookTitle, expectedBookAuthor);
        book.setId(expectedBookId);

        given(bookRepository.findAll()).willReturn(Arrays.asList(book));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", hasSize(1)))
                .andExpect(model().attribute("books", hasItem(
                    allOf(
                        hasProperty("id", is(expectedBookId)),
                        hasProperty("title", is(expectedBookTitle)),
                        hasProperty("author", is(expectedBookAuthor))
                    )
                )));
    }

    @Test
    public void testGetBook() throws Exception {
        Book book = new Book(expectedBookTitle, expectedBookAuthor);
        book.setId(expectedBookId);

        given(bookRepository.findById(expectedBookId)).willReturn(Optional.of(book));

        mockMvc.perform(get("/books/{id}", expectedBookId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(model().attributeExists("book"))
                .andExpect(model().attribute("book", hasProperty("id", is(expectedBookId))))
                .andExpect(model().attribute("book", hasProperty("title", is(expectedBookTitle))))
                .andExpect(model().attribute("book", hasProperty("author", is(expectedBookAuthor))));
    }
}