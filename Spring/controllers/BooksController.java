package Spring.controllers;

import Spring.models.Author;
import Spring.models.Book;
import Spring.models.Paragraph;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/books")
public class BooksController {
    private final JpaRepository<Book, Integer> booksRepository;

    @PostMapping
    public void createBook()
    {
        Book book = new Book("Titanic");
        book.addAuthor(new Author("Ion", "Creanga"));
        book.addContent(new Paragraph("Paragraph 1"));
        book = booksRepository.save(book);
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        Book book = booksRepository.getOne(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
