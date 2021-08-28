package pers.ruikai.pwms.compiler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import pers.ruikai.pwms.models.Category;
import pers.ruikai.pwms.warehouse.Warehouse;

public class CompilerTest {

    @Test
    void testConstructor() {
        Compiler compiler = new Compiler();
        assertNotNull(compiler);
    }

    @Test
    void testCompile() {
        Compiler compiler = new Compiler();
        Warehouse warehouse = null;
        try {
            warehouse = compiler.compile(getClass().getResourceAsStream("/test2.txt"));
        }
        catch(Exception e) {
            e.printStackTrace();
            fail();
        }

        List<Category> categories = warehouse.getCategories();
        assertEquals(2, categories.size());

    }
}
