package service;

import model.Category;

import java.util.List;

public interface ICategory {
    List<Category> getAll();

    Category findByID(int category);
}
