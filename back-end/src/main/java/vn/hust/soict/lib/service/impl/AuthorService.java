package vn.hust.soict.lib.service.impl;

import org.springframework.stereotype.Service;
import vn.hust.soict.lib.entity.Author;
import vn.hust.soict.lib.repository.AuthorRepository;
import vn.hust.soict.lib.service.IAuthorService;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Author getById(int id) {
        return null;
    }

    @Override
    public Author insert(int id, Author author) {
        return null;
    }

    @Override
    public Author update(int id) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }
}
