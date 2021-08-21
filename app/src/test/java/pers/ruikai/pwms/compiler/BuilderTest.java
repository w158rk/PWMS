package pers.ruikai.pwms.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import pers.ruikai.pwms.models.Category;
import pers.ruikai.pwms.warehouse.Warehouse;

public class BuilderTest {

    @Test
    void testConstructor() {
        Builder builder = new Builder();
        assertNotNull(builder);
    }

    @Test
    void testBuild() {
        Builder builder = new Builder();
        Warehouse warehouse = null;
        try {
            warehouse = builder.build(getClass().getResourceAsStream("/testfile"));
        }
        catch(Exception e) {
            e.printStackTrace();
            fail();
        }

        List<Category> categories = warehouse.getCategories();
        assertEquals(categories.size(), 2);

    }
}
