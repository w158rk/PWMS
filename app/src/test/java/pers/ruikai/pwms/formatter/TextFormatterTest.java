package pers.ruikai.pwms.formatter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import pers.ruikai.pwms.compiler.Builder;
import pers.ruikai.pwms.warehouse.Warehouse;


public class TextFormatterTest {
    @Test
    void testFormatter() {
        Builder builder = new Builder();
        Warehouse warehouse = null;
        try {
            warehouse = builder.build(getClass().getResourceAsStream("/testfile"));
        }
        catch(Exception e) {
            e.printStackTrace();
            fail();
        }

        String s = TextFormatter.format(warehouse);
        assertFalse(s.isBlank());

    }
}
