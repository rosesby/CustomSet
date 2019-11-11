package com.mcc;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Saul Alonso Palazuelos
 */
public class CustomLHSet<T> extends LinkedHashSet<T> {

    /**
     * Constructs a new, empty object instance of type {@link Set}&lt;T&gt
     */
    public CustomLHSet() {
    }

    /**
     * Constructs a new object instance of type {@link Set}&lt;T&gt
     * with the same elements as the specified T[] array
     *
     * @param array T[] array
     */
    public CustomLHSet(T[] array) {
        Arrays.stream(array).forEach(x -> add(x));
    }

    /**
     * Constructs a new an object instance of type {@link Set}&lt;T&gt
     * with the same elements as the specified T[] array
     *
     * @param collection {@link Collection}&lt;T&gt collection)
     */
    public CustomLHSet(Collection<T> collection) {
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
    public CustomLHSet<T> union(Collection<T> collection) {
        CustomLHSet<T> newSet = new CustomLHSet<>(this);
        newSet.addAll(collection);
        return newSet;
    }

    /**
     * Sean A y B dos conjuntos.
     * La intersección de A con B es el conjunto de aquellos elementos
     * que están en A y que están en B.
     *
     * @param collection
     * @return
     */
    public CustomLHSet<T> intersection(Collection<T> collection) {
        Stream<T> resultS = this.stream().filter(x -> collection.contains(x));
        Collection<T> resultC = resultS.collect(Collectors.toSet());
        return new CustomLHSet<T>(resultC);
    }

    /**
     * Sean A y B dos conjuntos.
     * La diferencia de A con B es el conjunto de aquellos elementos
     * que están en A y que no están en B.
     *
     * @param collection
     * @return
     */
    public CustomLHSet<T> difference(Collection<T> collection) {
        Stream<T> resultS = this.stream().filter(x -> !collection.contains(x));
        Collection<T> resultC = resultS.collect(Collectors.toSet());
        return new CustomLHSet<T>(resultC);
    }

    public boolean subset(Collection<T> collection) {
        return this.stream().allMatch(x -> collection.contains(x));
    }

    public boolean subsetP(Collection<T> collection) {
        boolean allMatch = this.stream().allMatch(x -> collection.contains(x));
        return allMatch && !this.equals(collection);
    }

    public CustomLHSet complement(Collection<T> collectionUniverse) {
        Stream<T> resultS = collectionUniverse.stream().filter(x -> !this.contains(x));
        Collection<T> resultC = resultS.collect(Collectors.toSet());
        return new CustomLHSet<T>(resultC);
    }

    public CustomLHSet<CustomPair<T, Object>> productC(Collection<? extends Object> collection) {
        CustomLHSet set1 = this;
        CustomLHSet set2 = new CustomLHSet(collection);

        CustomLHSet<CustomPair<T, Object>> pairs = new CustomLHSet<>();
        this.forEach(x -> collection.forEach(y -> pairs.add(new CustomPair<>(x, y))));

        return pairs;
    }

    public double powSize() {
        return Math.pow(2d, this.size());
    }

    public CustomLHSet<CustomLHSet<T>> pow() {
        List<T> list = new ArrayList<>(this);
        CustomLHSet<CustomLHSet<T>> newSets = new CustomLHSet<>();
        int setSize = this.size();

        //Loop runs from 0 to 2^setSize
        for (int i = 0; i < (1 << setSize); i++) {
            int actualElementBitNumer = 1;
            // Print current subset

            CustomLHSet<T> newSet = new CustomLHSet<T>();
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
        String name = setName;
        String tostr = this.toString();
        System.out.println(setName + " : " + tostr);
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
