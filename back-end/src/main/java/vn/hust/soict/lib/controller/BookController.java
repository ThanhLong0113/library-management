package vn.hust.soict.lib.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hust.soict.lib.entity.Book;
import vn.hust.soict.lib.service.IBookService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/books")
public class BookController {
    private final IBookService bookService;
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("")
    List<Book> getAllBooks() {
        return bookService.getAll();
    }
}
