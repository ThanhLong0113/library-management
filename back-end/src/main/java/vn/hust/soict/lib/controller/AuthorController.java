package vn.hust.soict.lib.controller;

import org.springframework.web.bind.annotation.RestController;
import vn.hust.soict.lib.service.IAuthorService;

@RestController
public class AuthorController {
    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }
}
