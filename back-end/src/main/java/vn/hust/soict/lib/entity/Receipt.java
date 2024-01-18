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
    @Column(name = "user_id")
    private int userId;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "staff_id")
    private int staffId;
    @Column(name = "borrowed_at")
    private Date borrowedAt;
    @Column(name = "back_at")
    private Date backAt;
    private double price;
}
