package uk.co.artofcode.java.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.Function;

/**
 * A List implementation, based on ArrayList, that can be queried using lambda expressions.
 * @param <T> the type of elements in this list
 * @author ArtOfCode
 */
public class QueryableList<T> extends ArrayList<T> {
    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public QueryableList() {
        super();
    }
    
    /**
     * Constructs an empty list with the specified initial capacity.
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is negative.
     */
    public QueryableList(int initialCapacity) {
        super(initialCapacity);
    }
    
    /**
     * Constructs a list containing the elements of the specified collection, in the order they are
     * returned by the collection's iterator.
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public QueryableList(Collection<? extends T> c) {
        super(c);
    }
    
    /**
     * Tests each element of this list against the specified predicate, and returns as a new list only
     * those elements for which the predicate returns true.
     * @param expr the predicate or lambda-expression with which to test each list element
     * @return a new QueryableList&lt;T&gt;, containing the elements which match the predicate
     * @throws NullPointerException if the given predicate is null
     */
    public QueryableList<T> query(Predicate<T> expr) {
        QueryableList<T> results = new QueryableList<>();
        this.forEach((T item) -> {
            if (expr.test(item)) {
                results.add(item);
            }
        });
        return results;
    }
    
    /**
     * Filters this list instance using the specified predicate. Elements for which the predicate returns
     * false are removed from the list.
     * @param expr the predicate or lambda-expression with which to test each list element
     * @throws NullPointerException if the given predicate is null
     */
    public void filter(Predicate<T> expr) {
        this.forEach((T item) -> {
            if (!expr.test(item)) {
                this.remove(item);
            }
        });
    }
    
    /**
     * Transforms this list by application of a function to each list item. The returned array contains the
     * return value of the given function for each list item.
     * @param expr the function to apply to each element of this list
     * @return an array containing return values of the function for every list element
     */
    public QueryableList<?> map(Function<T, ?> expr) {
        QueryableList<Object> results = new QueryableList<>();
        this.forEach((T item) -> {
            results.add(expr.apply(item));
        });
        return results;
    }
}
