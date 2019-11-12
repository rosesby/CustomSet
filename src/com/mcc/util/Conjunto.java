package com.mcc.util;

import org.apache.commons.lang3.SerializationUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Saul Alonso Palazuelos
 */
public class Conjunto<T> extends LinkedHashSet<T> {

    /**
     * Constructs a new, empty object instance of type {@link Set}&lt;T&gt
     */
    public Conjunto() {
    }

    /**
     * Constructs a new object instance of type {@link Set}&lt;T&gt
     * with the same elements as the specified T[] array
     *
     * @param array T[] array
     */
    public Conjunto(T[] array) {
        Arrays.stream(array).forEach(x -> add(x));
    }

    /**
     * Constructs a new an object instance of type {@link Set}&lt;T&gt
     * with the same elements as the specified T[] array
     *
     * @param collection {@link Collection}&lt;T&gt collection)
     */
    public Conjunto(Collection<T> collection) {
        super(collection);
    }

    /**
     * Sean A y B dos conjuntos.
     * La unión de A con B es el conjunto de aquellos elementos
     * que están en A o que están en B.
     *
     * @param collection
     * @return
     */
    public Conjunto<T> union(Collection<T> collection) {
        Conjunto<T> newSet = new Conjunto<>(this);
        newSet.addAll(collection);
        return newSet;
    }

    public Conjunto<T> empty(){
        return new Conjunto<>();
    }

    public boolean isEmpty(){
        return size() > 0;
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    /**
     * Sean A y B dos conjuntos.
     * La intersección de A con B es el conjunto de aquellos elementos
     * que están en A y que están en B.
     *
     * @param collection
     * @return
     */
    public Conjunto<T> intersection(Collection<T> collection) {
        Stream<T> resultS = this.stream().filter(x -> collection.contains(x));
        Collection<T> resultC = resultS.collect(Collectors.toSet());
        return new Conjunto<T>(resultC);
    }

    /**
     * Sean A y B dos conjuntos.
     * La diferencia de A con B es el conjunto de aquellos elementos
     * que están en A y que no están en B.
     *
     * @param collection
     * @return
     */
    public Conjunto<T> difference(Collection<T> collection) {
        Stream<T> resultS = this.stream().filter(x -> !collection.contains(x));
        Collection<T> resultC = resultS.collect(Collectors.toSet());
        return new Conjunto<T>(resultC);
    }

    public boolean subset(Collection<T> collection) {
        return collection.stream().allMatch(x -> this.contains(x));
    }

    public boolean subsetP(Collection<T> collection) {
        boolean allMatch = collection.stream().allMatch(x -> this.contains(x));
        return allMatch && !this.equals(collection);
    }

    public Conjunto complement(Collection<T> collectionUniverse) {
        Stream<T> resultS = collectionUniverse.stream().filter(x -> !this.contains(x));
        Collection<T> resultC = resultS.collect(Collectors.toSet());
        return new Conjunto<T>(resultC);
    }

    public <E> Conjunto<Par<T, E>> productC(Collection<E> collection) {
        Conjunto set1 = this;
        Conjunto set2 = new Conjunto(collection);

        Conjunto<Par<T, E>> pairs = new Conjunto<>();
        this.forEach(x -> collection.forEach(y -> pairs.add(new Par<>(x, y))));

        return pairs;
    }

    public double powSize() {
        return Math.pow(2d, this.size());
    }

    public Conjunto<Conjunto<T>> pow() {
        List<T> list = new ArrayList<>(this);
        Conjunto<Conjunto<T>> newSets = new Conjunto<>();
        int setSize = this.size();

        //Loop runs from 0 to 2^setSize
        for (int i = 0; i < (1 << setSize); i++) {
            int actualElementBitNumer = 1;
            // Print current subset

            Conjunto<T> newSet = new Conjunto<T>();
            for (int j = 0; j < setSize; j++) {
                int im = i & actualElementBitNumer;
                String ib = Integer.toBinaryString(i);
                String mb = Integer.toBinaryString(actualElementBitNumer);
                String imb = Integer.toBinaryString(im);
                if ((im) > 0) {
                    newSet.add(list.get(j));
                }
                actualElementBitNumer = actualElementBitNumer << 1;
            }
            newSets.add(newSet);
        }
        return newSets;
    }

    public void print() {
        System.out.println(this.toString());
    }

    public void print(String setName) {
        System.out.println(setName + " : " + this);
    }

    public Conjunto<T> clone(){
       return SerializationUtils.clone(this);
    }

    public List<T> toList(){
        return new ArrayList<T>(this);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        Queue<T> queue = new LinkedList(this);

        if (queue.size() > 0) {
            strBuilder.append(queue.poll());
            queue.forEach(x -> strBuilder.append(" , " + x));
        }
        return "{ " + strBuilder + " }";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
