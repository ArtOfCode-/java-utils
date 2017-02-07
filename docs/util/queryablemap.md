## `uk.co.artofcode.java.util.QueryableMap<K, V>`
A Map implementation, based on HashMap, that adds querying and filtering operations.

Param | Description
----- | -----------
`<K>` | The type of keys in this map.
`<V>` | The type of values in this map.

#### `public QueryableMap(int initialCapacity, float loadFactor)`
Constructs a map with the specified initial capacity and load factor.

Param | Description
----- | -----------
`initialCapacity` | The initial capacity of the map.
`loadFactor` | The load factor for the map.

#### `public QueryableMap(int initialCapacity)`
Constructs a map with the specified initial capacity and default load factor. As of Java 8u121, this
is 0.75.

Param | Description
----- | -----------
`initialCapacity` | The initial capacity of the map.

#### `public QueryableMap()`
Constructs a map with default initial capacity and load factor. As of Java 8u121, these are 10 and 
0.75 respectively.

#### `public QueryableMap(Collection<? extends java.util.AbstractMap.SimpleEntry> c)`
Constructs a map with default initial capacity and load factor, and populates it with the entries in
the specified collection. As of Java 8u121, defaults are 10 and 0.75 respectively.

Param | Description
----- | -----------
`c`   | The collection of entries to be transferred to the map.

#### `public QueryableMap<K, V> query(java.util.function.BiPredicate<K, V> expr)`
Tests each element of this map against the specified predicate, and returns as a new map only those
elements for which the predicate returns true.

Param | Description
----- | -----------
`expr` | The `BiPredicate` (or equivalent lambda expression) with which to test elements.

**Returns:** A new `QueryableMap<K, V>`, containing the elements that match the given predicate.

#### `public void filter(java.util.function.BiPredicate<K, V> expr)`
Filters this map by testing each element against the specified predicate. Elements for which the 
given predicate returns false are removed from the map. This method modifies the list in-place - if 
you wish to keep the list unmodified, use `query(expr)`.

Param | Description
----- | -----------
`expr` | The `BiPredicate` (or equivalent lambda expression) with which to test elements.
