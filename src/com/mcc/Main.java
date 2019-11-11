package com.mcc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Saul Alonso Palazuelos
 * @version A1
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("+++String Sets+++");

        String[] strings1 = new String[]{"A", "AB", "B"};
        CustomLHSet<String> set1 = new CustomLHSet<String>(strings1);

        Collection<String> strings2 = new ArrayList<>();
        strings2.add("A");
        strings2.add("AB");
        strings2.add("C");
        strings2.add("CD");
        strings2.add( "D" );
        strings2.add("E");
        CustomLHSet<String> set2 = new CustomLHSet<>(strings2);

        CustomLHSet<String> set3 = new CustomLHSet<>();
        set3.add("CD");
        set3.add( "D" );

        CustomLHSet<String> set4 = new CustomLHSet<>();
        set4.add("A");
        set4.add("AB");
        set4.add("B");
        set4.add("C");
        set4.add("CD");
        set4.add( "D" );
        set4.add("E");
        set4.add("F");
        set4.add("FG");
        set4.add("G");
        set4.add("H");

/*        set1.print("set1");
        set2.print("set2");
        set3.print("set3");
        set4.print("Universo String");*/

        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();

        System.out.println("+++Int Sets+++");

        CustomLHSet<Integer> set5 = new CustomLHSet<>();
        set5.add(1);
        set5.add(2);
        set5.add(4);

        CustomLHSet<Integer> set6 = new CustomLHSet<>();
        set6.add(3);
        set6.add(5);
        set6.add(8);

        CustomLHSet<Integer> set7 = new CustomLHSet<>();

        for (int i = 0; i <= 20; i++) {
            set7.add(i);
        }

/*        set5.print("set5");
        set6.print("set6");
        set7.print("Universe Int");

        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();

        System.out.println("\"woman\" ∈ set2 : " + set2.contains("woman"));
        System.out.println("\"holy\" ∈ set2 : " + set2.contains("holy"));
        System.out.println("|set2| : " + set2.size());

        set2.union(set1).print("set2 ⋃ set1");
        set2.intersection(set1).print("set2 ⋂ set1");
        set2.difference(set1).print("set2 - set1");
        System.out.println("set3 ⊆ set2 : " + set3.subsetP(set2));
        System.out.println("set3 ⊆ set3 : " + set3.subsetP(set3));
        System.out.println("set3 ⊂ set3 : " + set3.subset(set3));

        set1.productC(set2).print("set1 x set2");
        set1.productC(set5).print("set1 x set5");
        set5.productC(set1).print("set5 x set1");
        set2.complement(set4).print("complement set2");
        set5.complement(set7).print("complement set5");*/

       set2.pow().print("set2 pow");
    }
}
