package vn.hust.soict.lib.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
@Entity
@Table
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @Column(name = "borrowed_at")
    private Date borrowedAt;
    @Column(name = "back_at")
    private Date backAt;
    private double price;
}
