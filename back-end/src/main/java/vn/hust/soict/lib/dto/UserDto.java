package vn.hust.soict.lib.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDto implements Serializable {
    private Long id;
    private String name;
    private String email;
    private boolean gender;
    private String phone;
}
