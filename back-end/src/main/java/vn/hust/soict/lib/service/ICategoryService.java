package vn.hust.soict.lib.service;

import vn.hust.soict.lib.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
    Category getById(Long id);
    void insert(Category category);
    void update(Long id, Category newCategory);
    void delete(Long id);
}
