package vn.hust.soict.lib.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.hust.soict.lib.entity.Receipt;
import vn.hust.soict.lib.exception.NotFoundException;
import vn.hust.soict.lib.repository.ReceiptRepository;
import vn.hust.soict.lib.service.IReceiptService;

import java.util.Collections;
import java.util.List;

@Service
public class ReceiptService implements IReceiptService {
    private final ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @Override
    public List<Receipt> getAll() {
        return receiptRepository.findAll();
    }

    @Override
    public Receipt getById(Long id) {
        return receiptRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Không tìm thấy phiếu có id là %d", id)));
    }

    @Override
    public void insert(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    @Override
    public void update(Long id, Receipt newReceipt) {
        receiptRepository.save(newReceipt);
    }

    @Override
    public void delete(Long id) {
        Receipt receipt = receiptRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Không tìm thấy phiếu có id là %d", id)));
        receiptRepository.deleteById(receipt.getId());
    }

    @Override
    public Page<Receipt> findPaginated(Pageable pageable) {
        var pageSize = pageable.getPageSize();
        var currentPage = pageable.getPageNumber();
        var startItem = currentPage * pageSize;

        List<Receipt> receiptList;

        if(getAll().size() < startItem) {
            receiptList = Collections.emptyList();
        } else {
            var toIndex = Math.min(startItem + pageSize, getAll().size());
            receiptList = getAll().subList(startItem, toIndex);
        }
        return new PageImpl<Receipt>(receiptList, PageRequest.of(currentPage, pageSize), getAll().size());
    }
}
