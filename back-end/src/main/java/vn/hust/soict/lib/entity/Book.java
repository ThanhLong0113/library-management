package vn.hust.soict.lib.entity;

import lombok.Data;

import java.time.Year;
@Data
public class Book {
    private int id;
    private String name;
    private int authorId;
    private String publisher;
    private Year publishedYear;
    private int categoryId;
    private int quantity;
    private int borrowed;
    private int remaining;

}
