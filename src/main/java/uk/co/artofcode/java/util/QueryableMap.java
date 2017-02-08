package uk.co.artofcode.java.util;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collection;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.BiPredicate;
import java.util.Iterator;

/**
 * A Map implementation, based on HashMap, that adds querying and filtering operations.
 * @param <K> the type of keys in this map
 * @param <V> the type of values in this map
 * @author ArtOfCode
 */
public class QueryableMap<K, V> extends HashMap {
    /**
     * Constructs a map with the specified initial capacity and load factor.
     * @param initialCapacity the initial capacity
     * @param loadFactor the load factor
     */
    public QueryableMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }
    
    /**
     * Constructs a map with the specified initial capacity and default load factor.
     * @param initialCapacity the initial capacity
     */
    public QueryableMap(int initialCapacity) {
        super(initialCapacity);
    }
    
    /**
     * Constructs a map with default initial capacity and load factor.
     */
    public QueryableMap() {
        super();
    }
    
    /**
     * Constructs a map with default initial capacity and load factor, and populates it with the
     * entries in the specified collection.
     * @param c the collection of entries to be transferred to the map
     */
    public QueryableMap(Collection<? extends SimpleEntry> c) {
        c.forEach((SimpleEntry entry) -> {
            this.put(entry.getKey(), entry.getValue());
        });
    }
    
    /**
     * Tests each element of this map against the specified predicate, and returns as a new map only 
     * those elements for which the predicate returns true.
     * @param expr the BiPredicate with which to test elements
     * @return a new QueryableMap, containing th/**e elements of this list matching the given predicate
     */
    public QueryableMap<K, V> query(BiPredicate<K, V> expr) {
        QueryableMap<K, V> results = new QueryableMap();
        this.forEach((Object k, Object v) -> {
            K key = (K)k;
            V value = (V)v;
            if (expr.test(key, value)) {
                results.put(key, value);
            }
        });
        return results;
    }
    
    /**
     * Filters this map by testing each element against the specified predicate. Those elements for which
     * the predicate returns false are removed from the map. This method modifies the current map instance
     * in-place.
     * @param expr the BiPredicate with which to test elements
     */
    public void filter(BiPredicate<K, V> expr) {
        Iterator<Entry<K, V>> iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (!expr.test(entry.getKey(), entry.getValue())) {
                iterator.remove();
            }
        }
    }
}
