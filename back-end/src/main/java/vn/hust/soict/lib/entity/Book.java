package vn.hust.soict.lib.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.Year;
@Data
@Builder
@Table
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private String publisher;
    @Column(name = "publish_year")
    private Year publishedYear;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private int quantity;
    private int borrowed;
    private int remaining;

}
