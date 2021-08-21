package pers.ruikai.pwms.utils;

@FunctionalInterface
public interface ListElementMatcher<E> {
    boolean isMatch(E e);
}
