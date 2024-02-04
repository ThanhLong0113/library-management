package vn.hust.soict.lib.service.impl;

import org.springframework.stereotype.Service;
import vn.hust.soict.lib.entity.Category;
import vn.hust.soict.lib.exception.NotFoundException;
import vn.hust.soict.lib.repository.CategoryRepository;
import vn.hust.soict.lib.service.ICategoryService;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Không tìm thấy thể loại có id là %d", id)));
    }

    @Override
    public void insert(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Long id, Category newCategory) {
        Category updatedCategory = categoryRepository.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    return categoryRepository.save(category);
                }).orElseThrow(() -> new NotFoundException(String.format("Không tìm thấy thể loại có id là %d", id)));
    }

    @Override
    public void delete(Long id) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Không tìm thấy thể loại có id là %d", id)));
        categoryRepository.deleteById(category.getId());
    }
}
