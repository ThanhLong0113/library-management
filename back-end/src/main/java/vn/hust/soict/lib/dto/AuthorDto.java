package vn.hust.soict.lib.dto;

import lombok.Builder;
import lombok.Data;
import vn.hust.soict.lib.entity.Book;

import java.io.Serializable;
import java.util.List;
@Data
@Builder
public class AuthorDto implements Serializable {

    private Long id;
    private String name;
    private List<Book> books;
}
