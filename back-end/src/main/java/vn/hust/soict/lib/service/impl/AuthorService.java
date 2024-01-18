package vn.hust.soict.lib.service.impl;

import org.springframework.stereotype.Service;
import vn.hust.soict.lib.repository.AuthorRepository;
import vn.hust.soict.lib.service.IAuthorService;
@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
