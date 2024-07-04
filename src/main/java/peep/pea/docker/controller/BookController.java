package peep.pea.docker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peep.pea.docker.model.Book; 
import peep.pea.docker.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()) {
            return "error";
        }
        model.addAttribute("book", book.get());
        return "bookDetail";
    }


    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        Book book = new Book(); 
        model.addAttribute("book", book);
        return "add";
    }

    @PostMapping
    public String createBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/update/{id}")
    public String updateBookForm(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id)
                      .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        book.setId(id); // Set the ID to ensure the entity is updated
        bookRepository.save(book);
        return "redirect:/books"; // Redirects to the listing page after updating
    }
}
