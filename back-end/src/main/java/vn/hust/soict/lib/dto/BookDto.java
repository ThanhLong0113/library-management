package vn.hust.soict.lib.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.Year;

@Data
@Builder
public class BookDto implements Serializable {
    private Long id;
    private String name;
    private Long authorId;
    private String publisher;
    private Year publishedYear;
    private Long categoryId;
    private Long remaining;
}
