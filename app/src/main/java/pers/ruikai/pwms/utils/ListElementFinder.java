package pers.ruikai.pwms.utils;

import java.util.List;

/**
 * class to find the first element with some conditions hold in the list
 *
 * @version 0.0.1
 */
public class ListElementFinder<E> {
    private List<E> list;

    /**
     * constructor
     * @param list the list in which the search is performed
     */
    public ListElementFinder(List<E> list) {
        this.list = list;
    }

    /**
     * find the first element matching some conditions in the list
     * @param matcher a ListElementMatcher object, which can be a lambda expression
     * @return the first match or null if there is no matching element
     */
    public E findFirst(ListElementMatcher<E> matcher){
        if(list==null) return null;

        for (E e : list) {
            if(matcher.isMatch(e)) return e;
        }

        return null;
    }
}
