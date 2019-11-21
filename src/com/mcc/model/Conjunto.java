package com.mcc.model;

import org.apache.commons.lang3.SerializationUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Saul Alonso Palazuelos
 */
public class Conjunto<T> extends LinkedHashSet<T>  {

    private final Type type = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public Type getType(){
        return type;
    }

    public String getTypeNameString(){
        return this.getClass().getCanonicalName();
    }

    /**
     * Constructs a new, empty object instance of type {@link Set}&lt;T&gt
     */
    public Conjunto() {
    }

    /**
     * Constructs a new object instance of type {@link Set}&lt;T&gt
     * with the same elements as the specified T[] array
     * @param array T[] array
     */
    public Conjunto(T[] array) {
        Arrays.stream(array).forEach(x -> add(x));
    }

    /**
     * Constructs a new an object instance of type {@link Set}&lt;T&gt
     * with the same elements as the specified T[] array
     */
    public Conjunto(Collection<T> collection) {
        super(collection);
    }

/*    private <E extends Collection> boolean addAll(E c){
        return lhs.addAll(c);
    }*/

    /**
     * La unión de los conjuntos A y B
     * es el conjunto de aquellos elementos
     * que están en A o que están en B.
     */
    public <E> Conjunto union(Conjunto<E> c) {
        Conjunto newSet = new Conjunto<>();
        newSet.addAll(this);
        newSet.addAll(c);
        return newSet;
    }

    public <E> Conjunto<E> union2(Conjunto<?> b) {
        Conjunto newSet = new Conjunto<>();
        newSet.addAll(this);
        newSet.addAll(b);
        return newSet;
    }

    /**
     * La intersección de los conjuntos A y B
     * es el conjunto de aquellos elementos
     * que están en A y que están en B.
     */
    public Conjunto intersection(Conjunto<?> c) {
        Stream<?> resultS = this.stream().filter(x -> c.contains(x));
        Collection<Object> resultC = resultS.collect(Collectors.toSet());
        return new Conjunto(resultC);
    }

    private static Class<?> getCommonSuperclass(Class<?> a, Class<?> b) {
        Class<?> s = a;
        while (!s.isAssignableFrom(b)) {
            s = s.getSuperclass();
        }
        return s;
    }

    /**
     * La diferencia de los conjuntos A y B
     * es el conjunto de aquellos elementos
     * que están en A y que no están en B.
     */
    public Conjunto<T> difference(Conjunto<? extends Object> c) {
        Stream<T> resultS = this.stream().filter(x -> !c.contains(x));
        Collection<T> resultC = resultS.collect(Collectors.toSet());
        return new Conjunto<T>(resultC);
    }

    public boolean subset(Conjunto<T> c) {
        return c.stream().allMatch(x -> this.contains(x));
    }

    public boolean subsetP(Conjunto<T> c) { return subset(c) && !this.equals(c); }

    public Conjunto complement(Collection<T> collectionUniverse) {
        Stream<T> resultS = collectionUniverse.stream().filter(x -> !this.contains(x));
        Collection<T> resultC = resultS.collect(Collectors.toSet());
        return new Conjunto<T>(resultC);
    }

    public <E> Conjunto<Par<T, E>> productC(Conjunto<E> c) {
        Conjunto<Par<T, E>> pairs = new Conjunto<>();
        this.forEach(x -> c.forEach(y -> pairs.add(new Par<>(x, y))));
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

 /*   @Override
    private boolean equals(Object o){
      return super.equals(o);
    }*/
    
    public boolean equals(Conjunto<T> t) {
        return super.equals(t);
    }
}
