package vn.hust.soict.lib.entity;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private Date birthday;
    private boolean gender;
    private String phone;
    private String address;
}
