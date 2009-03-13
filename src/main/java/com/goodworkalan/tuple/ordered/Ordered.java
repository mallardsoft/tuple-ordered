package com.goodworkalan.tuple.ordered;

import com.mallardsoft.tuple.Decuple;
import com.mallardsoft.tuple.End;
import com.mallardsoft.tuple.Nonuple;
import com.mallardsoft.tuple.Octuple;
import com.mallardsoft.tuple.Pair;
import com.mallardsoft.tuple.Quadruple;
import com.mallardsoft.tuple.Quintuple;
import com.mallardsoft.tuple.Septuple;
import com.mallardsoft.tuple.Sextuple;
import com.mallardsoft.tuple.Single;
import com.mallardsoft.tuple.Triple;
import com.mallardsoft.tuple.Tuple;

/**
 * A container that maps an object to a strategy for ordering the object.
 * 
 * @author Alan Gutierrez
 * 
 * @param <T>
 *            The type of the object to order.
 */
public class Ordered<T extends Tuple<?, ?>> implements Comparable<Ordered<T>>
{
    /** The object to order. */
    private final T tuple;
    
    /** The comparable that orders other objects in relation to this object. */
    private final Comparable<? super T> comparable;

    /**
     * Create a container that maps the given object to the given strategy for
     * ordering other objects in relation to the object.
     * 
     * @param object
     *            The object.
     * @param comparable
     *            A comparable for the object.
     */
    public Ordered(T object, Comparable<? super T> comparable)
    {
        this.tuple = object;
        this.comparable = comparable;
    }
    
    /**
     * Get the object.
     * 
     * @return The object.
     */
    public T getTuple()
    {
        return tuple;
    }

    /**
     * Compare the object property to the given object.
     * 
     * @param o
     *            Another object.
     */
    public int compareTo(Ordered<T> o)
    {
        return comparable.compareTo(o.getTuple());
    }

    /**
     * Create an ordered tuple that will compare the given <code>Single</code>
     * tuple against other <code>Single</code> tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Single</code> tuple.
     * @param single
     *            The <code>Single</code> tuple.
     * @return An ordered tuple form the given single tuple.
     */
    public static <A extends Comparable<A>> Ordered<Single<A>> order(Single<A> single)
    {
        Order<A, End> order = Order.<A>last();
        return new Ordered<Single<A>>(single, order.comparable(single));
    }

    /**
     * Create an ordered tuple that will compare the given <code>Pair</code>
     * tuple against other <code>Pair</code> tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Pair</code> tuple.
     * @param <B>
     *            The second parameter in the <code>Pair</code> tuple.
     * @param pair
     *            The <code>Pair</code> tuple.
     * @return An ordered tuple form the given single tuple.
     */
    public static <A extends Comparable<A>, B extends Comparable<B>> Ordered<Pair<A, B>> order(Pair<A, B> pair)
    {
        Order<A, Tuple<B, End>> order = Order.<B>last().<A>prepend();
        return new Ordered<Pair<A, B>>(pair, order.comparable(pair));
    }
    
    /**
     * Create an ordered tuple that will compare the given <code>Triple</code>
     * tuple against other <code>Triple</code> tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Triple</code> tuple.
     * @param <B>
     *            The second parameter in the <code>Triple</code> tuple.
     * @param <C>
     *            The third parameter in the <code>Triple</code> tuple.
     * @param triple
     *            The <code>Triple</code> tuple.
     * @return An ordered tuple form the given <code>Triple</code> tuple.
     */
    public static <
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>
    > Ordered<Triple<A, B, C>> order(Triple<A, B, C> triple)
    {
        Order<A, Tuple<B, Tuple<C, End>>> order = Order.<C>last().<B>prepend().<A>prepend();
        return new Ordered<Triple<A, B, C>>(triple, order.comparable(triple));
    }

    /**
     * Create an ordered tuple that will compare the given
     * <code>Quadruple</code> tuple against other <code>Quadruple</code> tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Quadruple</code> tuple.
     * @param <B>
     *            The second parameter in the <code>Quadruple</code> tuple.
     * @param <C>
     *            The third parameter in the <code>Quadruple</code> tuple.
     * @param <D>
     *            The fourth parameter in the <code>Quadruple</code> tuple.
     * @param quadruple
     *            The <code>Quadruple</code> tuple.
     * @return An ordered tuple form the given <code>Quadruple</code> tuple.
     */
    public static <
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>,
        D extends Comparable<D>
    > Ordered<Quadruple<A, B, C, D>> order(Quadruple<A, B, C, D> quadruple)
    {
        Order<A, Tuple<B, Tuple<C, Tuple<D, End>>>> order = Order.<D>last().<C>prepend().<B>prepend().<A>prepend();
        return new Ordered<Quadruple<A, B, C, D>>(quadruple, order.comparable(quadruple));
    }

    /**
     * Create an ordered tuple that will compare the given
     * <code>Quintuple</code> tuple against other <code>Quintuple</code> tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Quintuple</code> tuple.
     * @param <B>
     *            The second parameter in the <code>Quintuple</code> tuple.
     * @param <C>
     *            The third parameter in the <code>Quintuple</code> tuple.
     * @param <D>
     *            The fourth parameter in the <code>Quintuple</code> tuple.
     * @param <E>
     *            The fifth parameter in the <code>Quintuple</code> tuple.
     * @param quintuple
     *            The <code>Quintuple</code> tuple.
     * @return An ordered tuple form the given <code>Quintuple</code> tuple.
     */
    public static <
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>,
        D extends Comparable<D>,
        E extends Comparable<E>
    > Ordered<Quintuple<A, B, C, D, E>> order(Quintuple<A, B, C, D, E> quintuple)
    {
        Order<A, Tuple<B, Tuple<C, Tuple<D, Tuple<E, End>>>>> order = Order.<E>last().<D>prepend().<C>prepend().<B>prepend().<A>prepend();
        return new Ordered<Quintuple<A, B, C, D, E>>(quintuple, order.comparable(quintuple));
    }

    /**
     * Create an ordered tuple that will compare the given <code>Sextuple</code>
     * tuple against other <code>Sextuple</code> tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Sextuple</code> tuple.
     * @param <B>
     *            The second parameter in the <code>Sextuple</code> tuple.
     * @param <C>
     *            The third parameter in the <code>Sextuple</code> tuple.
     * @param <D>
     *            The fourth parameter in the <code>Sextuple</code> tuple.
     * @param <E>
     *            The fifth parameter in the <code>Sextuple</code> tuple.
     * @param <F>
     *            The sixth parameter in the <code>Sextuple</code> tuple.
     * @param sextuple
     *            The <code>Sextuple</code> tuple.
     * @return An ordered tuple form the given <code>Sextuple</code> tuple.
     */
    public static <
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>,
        D extends Comparable<D>,
        E extends Comparable<E>,
        F extends Comparable<F>
    > Ordered<Sextuple<A, B, C, D, E, F>> order(Sextuple<A, B, C, D, E, F> sextuple)
    {
        Order<A, Tuple<B, Tuple<C, Tuple<D, Tuple<E, Tuple<F, End>>>>>> order = Order.<F>last().<E>prepend().<D>prepend().<C>prepend().<B>prepend().<A>prepend();
        return new Ordered<Sextuple<A, B, C, D, E, F>>(sextuple, order.comparable(sextuple));
    }

    /**
     * Create an ordered tuple that will compare the given <code>Septuple</code>
     * tuple against other <code>Septuple</code> tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Septuple</code> tuple.
     * @param <B>
     *            The second parameter in the <code>Septuple</code> tuple.
     * @param <C>
     *            The third parameter in the <code>Septuple</code> tuple.
     * @param <D>
     *            The fourth parameter in the <code>Septuple</code> tuple.
     * @param <E>
     *            The fifth parameter in the <code>Septuple</code> tuple.
     * @param <F>
     *            The sixth parameter in the <code>Septuple</code> tuple.
     * @param <G>
     *            The seventh parameter in the <code>Septuple</code> tuple.
     * @param septuple
     *            The <code>Septuple</code> tuple.
     * @return An ordered tuple form the given <code>Septuple</code> tuple.
     */
    public static <
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>,
        D extends Comparable<D>,
        E extends Comparable<E>,
        F extends Comparable<F>,
        G extends Comparable<G>
    > Ordered<Septuple<A, B, C, D, E, F, G>> order(Septuple<A, B, C, D, E, F, G> septuple)
    {
        Order<A, Tuple<B, Tuple<C, Tuple<D, Tuple<E, Tuple<F, Tuple<G, End>>>>>>> order = Order.<G>last().<F>prepend().<E>prepend().<D>prepend().<C>prepend().<B>prepend().<A>prepend();
        return new Ordered<Septuple<A, B, C, D, E, F, G>>(septuple, order.comparable(septuple));
    }

    /**
     * Create an ordered tuple that will compare the given <code>Octuple</code>
     * tuple against other <code>Octuple</code> tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Octuple</code> tuple.
     * @param <B>
     *            The second parameter in the <code>Octuple</code> tuple.
     * @param <C>
     *            The third parameter in the <code>Octuple</code> tuple.
     * @param <D>
     *            The fourth parameter in the <code>Octuple</code> tuple.
     * @param <E>
     *            The fifth parameter in the <code>Octuple</code> tuple.
     * @param <F>
     *            The sixth parameter in the <code>Octuple</code> tuple.
     * @param <G>
     *            The seventh parameter in the <code>Octuple</code> tuple.
     * @param <H>
     *            The eighth parameter in the <code>Octuple</code> tuple.
     * @param octuple
     *            The <code>Octuple</code> tuple.
     * @return An ordered tuple form the given <code>Octuple</code> tuple.
     */
    public static <
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>,
        D extends Comparable<D>,
        E extends Comparable<E>,
        F extends Comparable<F>,
        G extends Comparable<G>,
        H extends Comparable<H>
    > Ordered<Octuple<A, B, C, D, E, F, G, H>> order(Octuple<A, B, C, D, E, F, G, H> octuple)
    {
        Order<A, Tuple<B, Tuple<C, Tuple<D, Tuple<E, Tuple<F, Tuple<G, Tuple<H, End>>>>>>>> order = Order.<H>last().<G>prepend().<F>prepend().<E>prepend().<D>prepend().<C>prepend().<B>prepend().<A>prepend();
        return new Ordered<Octuple<A, B, C, D, E, F, G, H>>(octuple, order.comparable(octuple));
    }

    /**
     * Create an ordered tuple that will compare the given <code>Nonuple</code>
     * tuple against other <code>Nonuple</code> tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Nonuple</code> tuple.
     * @param <B>
     *            The second parameter in the <code>Nonuple</code> tuple.
     * @param <C>
     *            The third parameter in the <code>Nonuple</code> tuple.
     * @param <D>
     *            The fourth parameter in the <code>Nonuple</code> tuple.
     * @param <E>
     *            The fifth parameter in the <code>Nonuple</code> tuple.
     * @param <F>
     *            The sixth parameter in the <code>Nonuple</code> tuple.
     * @param <G>
     *            The seventh parameter in the <code>Nonuple</code> tuple.
     * @param <H>
     *            The eighth parameter in the <code>Nonuple</code> tuple.
     * @param <I>
     *            The ninth parameter in the <code>Nonuple</code> tuple.
     * @param nonuple
     *            The <code>Nonuple</code> tuple.
     * @return An ordered tuple form the given <code>Nonuple</code> tuple.
     */
    public static <
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>,
        D extends Comparable<D>,
        E extends Comparable<E>,
        F extends Comparable<F>,
        G extends Comparable<G>,
        H extends Comparable<H>,
        I extends Comparable<I>
    > Ordered<Nonuple<A, B, C, D, E, F, G, H, I>> order(Nonuple<A, B, C, D, E, F, G, H, I> nonuple)
    {
        Order<A, Tuple<B, Tuple<C, Tuple<D, Tuple<E, Tuple<F, Tuple<G, Tuple<H, Tuple<I, End>>>>>>>>> order = Order.<I>last().<H>prepend().<G>prepend().<F>prepend().<E>prepend().<D>prepend().<C>prepend().<B>prepend().<A>prepend();
        return new Ordered<Nonuple<A, B, C, D, E, F, G, H, I>>(nonuple, order.comparable(nonuple));
    }
    
    /**
     * Create an ordered tuple that will compare the given <code>Decuple</code>
     * tuple against other <code>Decuple</code> tuples.
     * 
     * @param <A>
     *            The first parameter in the <code>Decuple</code> tuple.
     * @param <B>
     *            The second parameter in the <code>Decuple</code> tuple.
     * @param <C>
     *            The third parameter in the <code>Decuple</code> tuple.
     * @param <D>
     *            The fourth parameter in the <code>Decuple</code> tuple.
     * @param <E>
     *            The fifth parameter in the <code>Decuple</code> tuple.
     * @param <F>
     *            The sixth parameter in the <code>Decuple</code> tuple.
     * @param <G>
     *            The seventh parameter in the <code>Decuple</code> tuple.
     * @param <H>
     *            The eighth parameter in the <code>Decuple</code> tuple.
     * @param <I>
     *            The ninth parameter in the <code>Decuple</code> tuple.
     * @param <J>
     *            The tenth parameter in the <code>Decuple</code> tuple.
     * @param decuple
     *            The <code>Decuple</code> tuple.
     * @return An ordered tuple form the given <code>Decuple</code> tuple.
     */
    public static <
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>,
        D extends Comparable<D>,
        E extends Comparable<E>,
        F extends Comparable<F>,
        G extends Comparable<G>,
        H extends Comparable<H>,
        I extends Comparable<I>,
        J extends Comparable<J>
    > Ordered<Decuple<A, B, C, D, E, F, G, H, I, J>> order(Decuple<A, B, C, D, E, F, G, H, I, J> decuple)
    {
        Order<A, Tuple<B, Tuple<C, Tuple<D, Tuple<E, Tuple<F, Tuple<G, Tuple<H, Tuple<I, Tuple<J, End>>>>>>>>>> order = Order.<J>last().<I>prepend().<H>prepend().<G>prepend().<F>prepend().<E>prepend().<D>prepend().<C>prepend().<B>prepend().<A>prepend();
        return new Ordered<Decuple<A, B, C, D, E, F, G, H, I, J>>(decuple, order.comparable(decuple));
    }
}
