package pers.ruikai.pwms.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.junit.jupiter.api.Test;

public class ListElementFinderTest {
    @Test
    void testFind() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(9);

        ListElementFinder<Integer> finder = new ListElementFinder<>(list);
        Integer found = null;
        try {
            found = finder.findFirst((Integer e) -> (e==5));
        }
        catch(Exception e) {
            fail();
        }

        assertEquals(found, list.get(1));
    }
}
