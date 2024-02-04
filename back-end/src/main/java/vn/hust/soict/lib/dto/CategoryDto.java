package vn.hust.soict.lib.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class CategoryDto implements Serializable {
    private Long id;
    private String name;
}
