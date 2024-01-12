package vn.hust.soict.lib.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Receipt {
    private int id;
    private int userId;
    private int bookId;
    private int staffId;
    private Date borrowedAt;
    private Date backAt;
    private double price;
}
