package com.mcc;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Saul Alonso Palazuelos
 * @version A1
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        // create an array of strings
        String[] strings = new String[]{"Hello", "World"};
        // create a new array to hold these strings
        CustomLHSet<String> array = new CustomLHSet<String>(strings);
        // get and print the first values (prints "Hello")
        array.forEach(x -> System.out.println(x));

        Collection<String> strings1 = new ArrayList<>();
        strings1.add("hello");
        strings1.add("Man");
        strings1.add( "girl" );
        strings1.add("woman");

        CustomLHSet<String> array1 = new CustomLHSet<String>(strings1);
        array1.forEach(x -> System.out.println(x));
    }
}
