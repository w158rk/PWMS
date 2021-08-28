package pers.ruikai.pwms.utils;

/**
 * auxillary interface for ListElementFinder
 *
 *
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
