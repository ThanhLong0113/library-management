package vn.hust.soict.lib.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.hust.soict.lib.entity.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    List<Author> getAll();
    Author getById(Long id);
    void insert(Author author);
    void update(Long id, Author newAuthor);
    void delete(Long id);
    Page<Author> findPaginated(Pageable pageable);
}
