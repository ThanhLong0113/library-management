package vn.hust.soict.lib.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.hust.soict.lib.entity.Receipt;

import java.util.List;

public interface IReceiptService {
    List<Receipt> getAll();
    Receipt getById(Long id);
    void insert(Receipt receipt);
    void update(Long id, Receipt newReceipt);
    void delete(Long id);
    Page<Receipt> findPaginated(Pageable pageable);

}
