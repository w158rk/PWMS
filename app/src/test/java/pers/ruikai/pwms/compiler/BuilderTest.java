package pers.ruikai.pwms.compiler;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class BuilderTest {
    @Test
    void testConstructor() {
        Builder builder = new Builder();
        assertNotNull(builder);
    }

    @Test
    void testBuild() {
        Builder builder = new Builder();
        try {
            builder.build(getClass().getResourceAsStream("/testfile"));
        }
        catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
