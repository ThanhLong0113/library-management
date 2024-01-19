package vn.hust.soict.lib.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Receipt> receipts;
    private Date birthday;
    private boolean gender;
    private String phone;
    private String address;

}
