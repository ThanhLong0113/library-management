package vn.hust.soict.lib.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
@Entity
@Table
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String role;
    private String password;
    private Date birthday;
    private boolean gender;
    private String phone;
    private String address;
}
