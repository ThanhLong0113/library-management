package vn.hust.soict.lib.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.hust.soict.lib.entity.Author;
import vn.hust.soict.lib.repository.AuthorRepository;
import vn.hust.soict.lib.service.IAuthorService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAll(int pageNumber, int pageSize) {
        Pageable pages = (Pageable) PageRequest.of(pageNumber, pageSize);
        return authorRepository.findAll(pages).getContent();
    }

    @Override
    public Optional<Author> getById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author insert(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(int id, Author author) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        boolean exists = authorRepository.existsById(id);
        if(exists) {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
