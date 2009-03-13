package com.goodworkalan.tuple.ordered;

/**
 * Create an implementation of comparable that will compare an object against
 * objects of the same type.
 * 
 * @author Alan Gutierrez
 * 
 * @param <T>
 *            The type of the object to order.
 */
interface ComparableServer<T>
{
    /**
     * Create an implementation of comparable that will compare the given object
     * against objects of the same type.
     * 
     * @param object
     *            The object to compare.
     * @return An implementation of comparable that will compare the given
     *         object against objects of the same type.
     */
    public Comparable<T> comparable(T object);
}
