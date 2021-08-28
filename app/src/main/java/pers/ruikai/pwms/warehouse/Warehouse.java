package pers.ruikai.pwms.warehouse;

import java.util.List;

import pers.ruikai.pwms.models.Category;

/**
 * class to represent a personal warehouse
 *
 *
 */
public class Warehouse {

    List<Category> categories = null;
    /**
     * constructor
     * @param list the list of categories in the warehouse
     */
    public Warehouse(List<Category> list) {
        this.categories = list;
    }

    /**
     * getter
     * @return the list of categories in the warehouse
     */
    public List<Category> getCategories() {
        return categories;
    }

}
