# java-utils
Set of utilities that I've needed at some point while writing Java; released here for your amusement.

## Dependency
This repository is not Central-hosted, so you need a `<repository>` tag in your pom.xml as well as the dependency:

    <repository>
        <id>GitHub-mvn-repo</id>
        <url>https://raw.github.com/ArtOfCode-/java-utils/mvn-repo/</url>
    </repository>
    
<!-- -->

    <dependency>
        <groupId>uk.co.artofcode.java</groupId>
        <artifactId>util</artifactId>
        <version>0.1-RELEASE</version>
    </dependency>
    
## Documentation
### `uk.co.artofcode.java.util.QueryableList<T>`
A List implementation, based on `ArrayList`, that allows lambda-expression based querying, filtering, and mapping. In addition to the methods detailed here, all the methods available from `ArrayList` are also available here.

 - **`public QueryableList<>()`**  
   The basic constructor: by delegation to the superclass' constructor, constructs an empty list with an initial
   capacity of ten.
   
 - **`public QueryableList<>(int initialCapacity)`**  
   By delegation to the superclass' constructor, constructs an empty list with the specified initial capacity.
   
   **Throws:** `IllegalArgumentException` if the specified initial capacity is negative.
   
 - **`public QueryableList<>(Collection<? extends T> c)`**  
   By delegation to the superclass' constructor, constructs a list containing the elements of the given collection,
   in the order they are returned by the collection's iterator. You can use `Arrays.asList` with this constructor.
   
   **Throws:** `NullPointerException` if the given collection is null.
   
 - **`public QueryableList<T> query(Predicate<T> expr)`**  
   Tests each element of this list using the specified predicate, and returns as a new list only those elements for 
   which the predicate returns true.
   
   For example:
   
       QueryableList<String> testList = new QueryableList<>(Arrays.asList("1", "1 2", "1 2 3", "1 2 3 4"));
       QueryableList<String> results = testList.query((String s) -> s.split(" ").length > 2);
       
   **Throws:** `NullPointerException` if the given predicate is null.
   
 - **`public void filter(Predicate<T> expr)`**  
   Filters this list instance using the specified predicate. Elements for which the predicate returns
   false are removed from the list. This method modifies this list instance in-place; if you want to leave this list
   unmodified, use `query`.
   
   For example:
   
       QueryableList<String> testList = new QueryableList<>(Arrays.asList("1", "1 2", "1 2 3", "1 2 3 4"));
       testList.filter((String s) -> s.split(" ").length > 2);
       
   In this example, the two elements with fewer than two "words" in them are removed from the list. The list now has two
   elements in it.
   
   **Throws:** `NullPointerException` if the given predicate is null.
   
 - **`public QueryableList<?> map(Function<T, ?> expr)`**  
   Transforms this list by application of a function to each list item. The returned list contains the
   return value of the given function for each list item. This method does *not* modify the list in-place, instead
   allocating and returning a new list.
   
   For example:
   
       QueryableList<String> testList = new QueryableList<>(Arrays.asList("ABC", "DEF", "GHI", "JKL"));
       QueryableList<Character> firstChars = (QueryableList<Character>) testList.map((String s) -> s.charAt(0));
       
   To avoid errors caused by the generic type argument, you should cast the result of `map` to a `QueryableList<T>`,
   where T is the return type of the specified function.
   
   **Throws:** `NullPointerException` if the given function is null.
    