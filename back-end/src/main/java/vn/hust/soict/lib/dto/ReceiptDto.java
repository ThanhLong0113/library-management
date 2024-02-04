package vn.hust.soict.lib.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class ReceiptDto implements Serializable {
    private Long id;
    private Long userId;
    private Long bookId;
    private Long staffId;
    private Date borrowedAt;
    private Date backAt;
    private double price;
}
