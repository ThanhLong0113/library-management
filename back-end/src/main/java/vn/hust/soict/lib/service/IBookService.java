package vn.hust.soict.lib.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.hust.soict.lib.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> getAll();
    List<Book> search(String keyword);
    Book getById(Long id);
    void insert(Book book);
    void update(Long id, Book newBook);
    void delete(Long id);
    Page<Book> findPaginated(Pageable pageable);
}
