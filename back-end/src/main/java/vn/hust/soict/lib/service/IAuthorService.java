package vn.hust.soict.lib.service;

import vn.hust.soict.lib.entity.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll(int pageNumber, int pageSize);
    Author getById(int id);
    Author insert(int id, Author author);
    Author update(int id);
    Boolean delete(int id);
}
