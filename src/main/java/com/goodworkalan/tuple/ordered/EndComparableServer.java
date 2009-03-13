package com.goodworkalan.tuple.ordered;

import com.mallardsoft.tuple.End;

/**
 * An implementation of comparable server that returns an end comparable that
 * always returns equal.
 * 
 * @author Alan Gutierrez
 */
class EndComparableServer implements ComparableServer<End>, Comparable<End>
{
    /**
     * Get an implementation of comparable that will compare the given end to
     * another end and always return equal.
     * 
     * @return An end comparable.
     */
    public Comparable<End> comparable(End object)
    {
        return this;
    }

    /**
     * Return zero since ends are always equal.
     * 
     * @return Zero.
     */
    public int compareTo(End o)
    {
        return 0;
    }
}
