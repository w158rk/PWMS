package pers.ruikai.pwms.warehouse;

import java.util.List;

import pers.ruikai.pwms.models.Category;

public class Warehouse {

    List<Category> categories = null;
    public Warehouse(List<Category> list) {
        this.categories = list;
    }

    public List<Category> getCategories() {
        return categories;
    }

}
