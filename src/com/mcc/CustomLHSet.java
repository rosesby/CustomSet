package com.mcc;

import java.util.*;

/**
 * @author Saul Alonso Palazuelos
 */
public class CustomLHSet<T> extends LinkedHashSet<T> {

    /**
     * Constructs a new, empty object instance of type {@link Set}&lt;T&gt
     */
    public CustomLHSet() { }

    /**
     * Constructs a new object instance of type {@link Set}&lt;T&gt
     * with the same elements as the specified T[] array
     * @param array T[] array
     */
    public CustomLHSet(T[] array) {
        Arrays.stream(array).forEach(x -> add(x));
    }

    /**
     * Constructs a new an object instance of type {@link Set}&lt;T&gt
     * with the same elements as the specified T[] array
     * @param collection {@link Collection}&lt;T&gt collection)
     */
    public CustomLHSet(Collection<T> collection){
        super(collection);
    }

}
