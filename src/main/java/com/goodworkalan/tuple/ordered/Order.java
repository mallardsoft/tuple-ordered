package com.goodworkalan.tuple.ordered;

import com.mallardsoft.tuple.End;
import com.mallardsoft.tuple.Tuple;
import com.mallardsoft.tuple.Variable;

/**
 * A comparable builder that creates an implementation of comparable that
 * compares a tuple member in a tuple and then propagates the comparison to the
 * next comparable builder.
 * 
 * @author Alan Gutierrez
 * 
 * @param <First>
 *            The type of the tuple member.
 * @param <Rest>
 *            The type of the remainder of the tuple.
 */
public class Order<First extends Comparable<First>, Rest> implements ComparableServer<Tuple<First, Rest>>
{
    /**
     * A comparable server that creates a comparable for the rest of the tuple.
     */
    private final ComparableServer<Rest> compareRest;

    /**
     * Create a step in a tuple comparison.
     * 
     * @param compareRest
     *            A comparable server that creates a comparable for the rest of
     *            the tuple.
     */
    Order(ComparableServer<Rest> compareRest)
    {
        this.compareRest = compareRest;
    }
    
    /**
     * Begin the reverse construction of an tuple comparison.
     * 
     * @return The penultimate step in a tuple comparison.
     */
    public static <A extends Comparable<A>> Order<A, End> last()
    {
        return new Order<A, End>(new EndComparableServer());
    }

    /**
     * Prepend the a step in a tuple comparison for the given tuple member type.
     * 
     * @param <T>
     *            The tuple member type.
     * @return A tuple comparison that begins with a comparison of the given
     *         tuple member type.
     */
    public <T extends Comparable<T>> Order<T, Tuple<First, Rest>> prepend() 
    {
        return new Order<T, Tuple<First, Rest>>(this);
    }

    /**
     * Create a comparable that will compare the given tuple against other
     * tuples of the same type.
     * 
     * @param tuple
     *            The tuple to compare.
     * @return A comparable that will compare the given tuple against other
     *         tuples of the same type.
     */
    public Comparable<Tuple<First, Rest>> comparable(Tuple<First, Rest> tuple)
    {
        Variable<First> v1 = new Variable<First>();
        final Rest r1 = tuple.extract(v1);
        final First f1 = v1.get();
        return new Comparable<Tuple<First,Rest>>()
        {
            public int compareTo(Tuple<First, Rest> other)
            {
                Variable<First> v2 = new Variable<First>();
                Rest r2 = other.extract(v2);
                First f2 = v2.get();
                if (f1 == null)
                {
                    if (f2 == null)
                    {
                        return compareRest.comparable(r1).compareTo(r2);
                    }
                    return -1;
                }
                else if (f2 == null)
                {
                    return 1;
                }
                int compare = f1.compareTo(v2.get());
                if (compare == 0)
                {
                    return compareRest.comparable(r1).compareTo(r2);
                }
                return compare;
            }
        };
    }
}
