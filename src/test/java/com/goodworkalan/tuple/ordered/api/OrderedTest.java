package com.goodworkalan.tuple.ordered.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.TreeSet;

import org.testng.annotations.Test;

import com.goodworkalan.tuple.ordered.Ordered;
import com.mallardsoft.tuple.Pair;
import com.mallardsoft.tuple.Tuple;

public class OrderedTest
{
    @Test
    public void ordered()
    {
        Ordered<Pair<String, Integer>> pair = Ordered.order(Tuple.from("A", 1));
        assertEquals(Tuple.get1(pair.getTuple()), "A");
        assertEquals((int) Tuple.get2(pair.getTuple()), 1);
        
        assertEquals((int) pair.compareTo(Ordered.order(Tuple.from("A", 1))), 0);
        
        assertTrue((int) pair.compareTo(Ordered.order(Tuple.from("A", 0))) > 0);
        assertTrue((int) pair.compareTo(Ordered.order(Tuple.from("B", 0))) < 0);
        assertTrue((int) pair.compareTo(Ordered.order(Tuple.from("A", 2))) < 0);
        assertTrue((int) pair.compareTo(Ordered.order(Tuple.from((String) null, 2))) > 0);
        assertTrue((int) Ordered.order(Tuple.from((String) null, 2)).compareTo(pair) < 0);
        assertTrue((int) Ordered.order(Tuple.from((String) null, 2)).compareTo(Ordered.order(Tuple.from((String) null, 2))) == 0);
    }
    
    @Test
    public void tree()
    {
        TreeSet<Ordered<Pair<String, Integer>>> tree = new TreeSet<Ordered<Pair<String,Integer>>>();
        
        tree.add(Ordered.order(Tuple.from("A", 1)));
        tree.add(Ordered.order(Tuple.from("A", 2)));
        tree.add(Ordered.order(Tuple.from("B", 1)));
        tree.add(Ordered.order(Tuple.from("B", 1)));
        tree.add(Ordered.order(Tuple.from("B", 1)));
        tree.add(Ordered.order(Tuple.from("B", 0)));
        
        assertEquals(tree.size(), 4);
        Iterator<Ordered<Pair<String, Integer>>> pairs = tree.iterator();
        assertTrue(pairs.hasNext());
        assertEquals(pairs.next().getTuple(), Tuple.from("A", 1));
        assertTrue(pairs.hasNext());
        assertEquals(pairs.next().getTuple(), Tuple.from("A", 2));
        assertTrue(pairs.hasNext());
        assertEquals(pairs.next().getTuple(), Tuple.from("B", 0));
        assertTrue(pairs.hasNext());
        assertEquals(pairs.next().getTuple(), Tuple.from("B", 1));
        assertFalse(pairs.hasNext());
    }
    
    @Test
    public void single()
    {
        assertEquals(Ordered.order(Tuple.from(1)).compareTo(Ordered.order(Tuple.from(1))), 0);
    }
    
    @Test
    public void triple()
    {
        assertEquals(Ordered.order(Tuple.from(1, 2, 3)).compareTo(Ordered.order(Tuple.from(1, 2, 3))), 0);
    }
    
    @Test
    public void quadruple()
    {
        assertEquals(Ordered.order(Tuple.from(1, 2, 3, 4)).compareTo(Ordered.order(Tuple.from(1, 2, 3, 4))), 0);
    }
    
    @Test
    public void quintuple()
    {
        assertEquals(Ordered.order(Tuple.from(1, 2, 3, 4, 5)).compareTo(Ordered.order(Tuple.from(1, 2, 3, 4, 5))), 0);
    }
    
    @Test
    public void sextuple()
    {
        assertEquals(Ordered.order(Tuple.from(1, 2, 3, 4, 5, 6)).compareTo(Ordered.order(Tuple.from(1, 2, 3, 4, 5, 6))), 0);
    }
    
    @Test
    public void septuple()
    {
        assertEquals(Ordered.order(Tuple.from(1, 2, 3, 4, 5, 6, 7)).compareTo(Ordered.order(Tuple.from(1, 2, 3, 4, 5, 6, 7))), 0);
    }
    
    @Test
    public void octuple()
    {
        assertEquals(Ordered.order(Tuple.from(1, 2, 3, 4, 5, 6, 7, 8)).compareTo(Ordered.order(Tuple.from(1, 2, 3, 4, 5, 6, 7, 8))), 0);
    }
    
    @Test
    public void nonuple()
    {
        assertEquals(Ordered.order(Tuple.from(1, 2, 3, 4, 5, 6, 7, 8, 9)).compareTo(Ordered.order(Tuple.from(1, 2, 3, 4, 5, 6, 7, 8, 9))), 0);
    }
    
    @Test
    public void decuple()
    {
        assertEquals(Ordered.order(Tuple.from(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).compareTo(Ordered.order(Tuple.from(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))), 0);
    }
}
