package pers.ruikai.pwms.utils;

/**
 * auxillary interface for ListElementFinder
 *
 * @version 0.0.1
 */
@FunctionalInterface
public interface ListElementMatcher<E> {
    /**
     *
     * @param e element
     * @return if the element satisfies the condition
     */
    boolean isMatch(E e);
}
