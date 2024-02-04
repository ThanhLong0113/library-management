package vn.hust.soict.lib.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.hust.soict.lib.entity.Author;
import vn.hust.soict.lib.exception.NotFoundException;
import vn.hust.soict.lib.repository.AuthorRepository;
import vn.hust.soict.lib.service.IAuthorService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Không thể tìm thấy tác giá có id là %d", id)));
    }

    @Override
    public void insert(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void update(Long id, Author newAuthor) {
        Author updatedAuthor = authorRepository.findById(id)
                .map(author -> {
                    author.setName(newAuthor.getName());
                    author.setBooks(newAuthor.getBooks());
                    return authorRepository.save(author);
                }).orElseGet(() -> {
                    newAuthor.setId(id);
                    return authorRepository.save(newAuthor);
                });
    }

    @Override
    public void delete(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Không thể tìm thấy tác giá có id là %d", id)));
        authorRepository.deleteById(author.getId());
    }

    @Override
    public Page<Author> findPaginated(Pageable pageable) {
        var pageSize = pageable.getPageSize();
        var currentPage = pageable.getPageNumber();
        var startItem = currentPage * pageSize;

        List<Author> authorList;

        if(getAll().size() < startItem) {
            authorList = Collections.emptyList();
        } else {
            var toIndex = Math.min(startItem + pageSize, getAll().size());
            authorList = getAll().subList(startItem, toIndex);
        }
        return new PageImpl<Author>(authorList, PageRequest.of(currentPage, pageSize), getAll().size());
    }
}
