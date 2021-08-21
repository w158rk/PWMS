package pers.ruikai.pwms.utils;

import java.util.List;
import java.util.concurrent.Callable;

public class ListElementFinder<E> {
    private List<E> list;

    public ListElementFinder(List<E> list) {
        this.list = list;
    }

    public E findFirst(ListElementMatcher<E> matcher) throws Exception{
        if(list==null) return null;

        for (E e : list) {
            if(matcher.isMatch(e)) return e;
        }

        return null;
    }
}
