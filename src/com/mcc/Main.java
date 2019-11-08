package com.mcc;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // create an array of strings
        String[] strings = new String[]{"Hello", "World"};

        // create a new array to hold these strings
        CustomSet<String> array = new CustomSet<String>(strings);

        // get and print the first values (prints "Hello")
        System.out.println(array.get(0));

        // set the second value
        array.set(1, "Javaland!");

        // iterate over the array, printing "Hello\nJavaland!"
        for (String s : array) {
            System.out.println(s);
        }

    }
}
