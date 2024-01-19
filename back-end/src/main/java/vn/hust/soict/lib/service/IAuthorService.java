package vn.hust.soict.lib.service;

import vn.hust.soict.lib.entity.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    List<Author> getAll(int pageNumber, int pageSize);
    Optional<Author> getById(int id);
    Author insert(Author author);
    Author update(int id, Author author);
    Boolean delete(int id);
}
