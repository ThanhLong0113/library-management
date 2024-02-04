package vn.hust.soict.lib.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.hust.soict.lib.entity.Author;
import vn.hust.soict.lib.entity.Book;
import vn.hust.soict.lib.exception.NotFoundException;
import vn.hust.soict.lib.repository.BookRepository;
import vn.hust.soict.lib.service.IBookService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> search(String keyword) {
        if(keyword != null) {
            return bookRepository.search(keyword);
        }
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Không tìm thấy sách có id là %d", id)));
    }

    @Override
    public void insert(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Long id, Book newBook) {
        Book updatedBook = bookRepository.findById(id)
                .map(book -> {
                    book.setQuantity(newBook.getQuantity());
                    book.setBorrowed(newBook.getBorrowed());
                    book.setRemaining(newBook.getRemaining());
                    return bookRepository.save(book);
                }).orElseThrow(() -> new NotFoundException(String.format("Không tìm thấy sách có id là %d", id)));
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Không thể tìm thấy sách có id là %d", id)));
        bookRepository.deleteById(book.getId());
    }

    @Override
    public Page<Book> findPaginated(Pageable pageable) {
        var pageSize = pageable.getPageSize();
        var currentPage = pageable.getPageNumber();
        var startItem = currentPage * pageSize;

        List<Book> bookList;

        if(getAll().size() < startItem) {
            bookList = Collections.emptyList();
        } else {
            var toIndex = Math.min(startItem + pageSize, getAll().size());
            bookList = getAll().subList(startItem, toIndex);
        }
        return new PageImpl<Book>(bookList, PageRequest.of(currentPage, pageSize), getAll().size());
    }
}
