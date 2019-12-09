package com.mcc;

import com.mcc.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Saul Alonso Palazuelos
 * @version A1
 */

public class Main {
    public static void main(String[] args) {
        //test0();
        //test1();
        //test2();
        //test3();
        //test4();

        Conjunto<Integer> integer1 = new Conjunto<>(new Integer[]{1, 2, 3, 4, 5});
        Conjunto<Integer> integer2 = new Conjunto<>(new Integer[]{6, 7, 8, 9, 10});
        Conjunto<String> string1 = new Conjunto<>(new ArrayList<>(List.of("victor","Saul","Misael")));
        Conjunto<String> string2 = new Conjunto<>(new ArrayList<>(List.of("manuel","glenn","oscar")));

        Student victor = new Student("Victor", "Batiz", Sex.M, LocalDate.of(1990,2,1), 28383);
        Student saul = new Student("Saul", "Alonso", Sex.M, LocalDate.of(1995,8,7), 28384);
        Student misael = new Student("Misael", "Zazueta", Sex.M, LocalDate.of(1995,8,7), 28385);
        Student plata = new Student("Luis Marcos", "Plata", Sex.M, LocalDate.of(1995,8,7), 28386);

        Teacher barron = new Teacher("Lucía", "Barron", Sex.F, LocalDate.of(1990,4,5),1002,Grade.PHD);
        Teacher ramon = new Teacher("Ramón", "Zatarain", Sex.M, LocalDate.of(1990,3,1),1001,Grade.PHD);

        Conjunto<Student> student = new Conjunto<>();
        Conjunto<Teacher> teachers = new Conjunto<>();

        student.add(victor);
        student.add(saul);
        student.add(misael);
        student.add(plata);

        teachers.add(barron);
        teachers.add(ramon);

        Conjunto<Person> personas1 = student.union(teachers);
        Conjunto<Person> personas2 = student.union2(teachers);
        personas1.print("Union");
        personas2.print("Union");

        integer1.union(string1).union(teachers).print("Remix");
    }

    private static void test4() {
        System.out.println("+++String Sets+++");

        String[] strings1 = new String[]{"A", "AB", "B"};
        Conjunto<String> set1 = new Conjunto<String>(strings1);

        Collection<String> strings2 = new ArrayList<>();
        strings2.add("A");
        strings2.add("AB");
        strings2.add("C");
        strings2.add("CD");
        strings2.add("D");
        strings2.add("E");
        Conjunto<String> set2 = new Conjunto<>(strings2);

        Conjunto<String> set3 = new Conjunto<>();
        set3.add("CD");
        set3.add("D");

        Conjunto<String> set4 = new Conjunto<>();
        set4.add("A");
        set4.add("AB");
        set4.add("B");
        set4.add("C");
        set4.add("CD");
        set4.add("D");
        set4.add("E");
        set4.add("F");
        set4.add("FG");
        set4.add("G");
        set4.add("H");

        set1.print("set1");
        set2.print("set2");
        set3.print("set3");
        set4.print("Universo String");

        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();

        System.out.println("+++Int Sets+++");

        Conjunto<Integer> set5 = new Conjunto<>();
        set5.add(1);
        set5.add(2);
        set5.add(4);

        Conjunto<Integer> set6 = new Conjunto<>();
        set6.add(3);
        set6.add(5);
        set6.add(8);

        Conjunto<Integer> set7 = new Conjunto<>();

        for (int i = 0; i <= 20; i++) {
            set7.add(i);
        }

        set5.print("set5");
        set6.print("set6");
        set7.print("Universe Int");

        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();

        String A = "A";
        String BC = "BC";
        System.out.println("\"A\" ∈ set2 : " + set2.contains(A));
        System.out.println("\"BC\" ∈ set2 : " + set2.contains(BC));
        System.out.println("|set2| : " + set2.size());

        set2.union(set1).print("set2 ⋃ set1");
        set2.intersection(set1).print("set2 ⋂ set1");
        set2.difference(set1).print("set2 - set1");
        System.out.println("set2 ⊆ set3 : " + set3.subsetP(set2));
        System.out.println("set3 ⊆ set2 : " + set2.subsetP(set3));
        System.out.println("set3 ⊆ set3 : " + set3.subsetP(set3));
        System.out.println("set3 ⊂ set3 : " + set3.subset(set3));

        set1.productC(set2).print("set1 x set2");
        set1.productC(set5).print("set1 x set5");
        set5.productC(set1).print("set5 x set1");
        set2.complement(set4).print("complement set2");
        set5.complement(set7).print("complement set5");

        set1.pow().print("set1 pow");

        var clonedSet = set1.clone();
        clonedSet.print("Cloned Set1");

        System.out.println("\n+++Día 1 String Sets Dra. Lucia Barrón+++");
        Integer[] arreglo = {1,2,3,3,3,1,5};
        String[] nombres = new String[]{"Víctor", "Alma Irán", "Yolanda"};
        Conjunto<Integer> a = new Conjunto();
        Conjunto<Integer> b = new Conjunto<>(arreglo);
        Conjunto<String> c = new Conjunto<>(nombres);
        Conjunto n;
        n = c.union(b);
        n.print("Conjunto n");

        System.out.println("\n+++Pruebas clase personas+++");

        System.out.println(b.contains("321"));
        Conjunto<Person> p1 = new Conjunto();
        Conjunto<Person> p2 = new Conjunto();

        Person victor = new Person("Victor", "Batiz", Sex.M, LocalDate.of(1990,2,1));
        Person saul = new Person("Saul", "Alonso", Sex.M, LocalDate.of(1995,8,7));
        Person misael = new Person("Misael", "Zazueta", Sex.M, LocalDate.of(1995,8,7));
        Person plata = new Person("Luis Marcos", "Plata", Sex.M, LocalDate.of(1995,8,7));

        p1.add(victor);
        p1.add(saul);
        p1.add(plata);

        p2.add(victor);
        p2.add(saul);
        p2.add(misael);

        p1.print("p1 : ");
        p2.print("p2 : ");

        var p3 = p1.union(p2);

        p3.print("p1 U p2 : ");
        p3.print();

        System.out.println("p3 contains Misael" + p3.contains(misael));
        System.out.println("p3 contains '1'" + p3.contains(1));

        System.out.println("\n+++Pruebas día 2 Sets Dra. Lucia Barrón+++");
        Integer[] aC1 = {1,2,3};
        Conjunto<Integer> c1 = new Conjunto<>(aC1);
        c1.print("Conjunto C1");
        Integer[] aC2 = {5,7,9};
        Conjunto<Integer> c2 = new Conjunto<>(aC2);
        c2.print("Conjunto C2");
        Integer[] aC3 = {1};
        Conjunto<Integer> c3 = new Conjunto<>(aC3);
        c3.print("Conjunto C3");
        Conjunto[] i4 = {c1,c2,c3};
        Conjunto<Conjunto> c4 = new Conjunto(i4);
        c4.print("Conjunto C4");
        if (c4.contains(c3)) {
            System.out.println("C4 Si contiene a C3");
        } else {
            System.out.println("C4 No contiene a C3");
        }
        c1 = c1.difference(c3);
        c1.print("Conjunto C1");
        c4.print("Conjunto C4");
    }

    private static void test3() {
        Integer[] i1 = {1,2,3};
        Integer[] i2 = {5,7,9};
        Integer[] i3 = {1};

        Conjunto<Integer> c1 = new Conjunto<>(i1);
        Conjunto<Integer> c2 = new Conjunto<>(i2);
        Conjunto<Integer> c3 = new Conjunto<>(i3);

        Conjunto[] e4 = {c1,c2,c3};

        Conjunto<Conjunto<Integer>> c4 = new Conjunto<>(e4);

        c4.print();

        System.out.println("c4 contains c3 " + c4.contains(c3));

        c1 = c1.difference(c3);

        c1.print();
        c3.print();

        var c5 = c4.clone();

        c1 = new Conjunto<>();

        c1.print();
        c5.print();
    }

    private static void test1() {
        Conjunto<Object> a = new Conjunto<>();

        Integer[] ints = new Integer[]{1,2,3,3};
        Conjunto<Integer> b = new Conjunto<Integer>(ints);

        Collection<String> nombres = new ArrayList<>();
        nombres.add("Victor");
        nombres.add("Misael");
        nombres.add("Saul");
        Conjunto<String> c = new Conjunto<>(nombres);

        Conjunto n = new Conjunto();

        n = b.union(c);

        n.print("union set int with set string");
    }

    private static void test2(){
        Conjunto<Person> p1 = new Conjunto();
        Conjunto<Person> p2 = new Conjunto();

        Person victor = new Person("Victor", "Batiz", Sex.M, LocalDate.of(1990,2,1));
        Person saul = new Person("Saul", "Alonso", Sex.M, LocalDate.of(1995,8,7));
        Person misael = new Person("Misael", "Zazueta", Sex.M, LocalDate.of(1995,8,7));
        Person plata = new Person("Luis Marcos", "Plata", Sex.M, LocalDate.of(1995,8,7));

        p1.add(victor);
        p1.add(saul);
        p1.add(plata);

        p2.add(victor);
        p2.add(saul);
        p2.add(misael);

        var p3 = p1.union(p2);

        System.out.println(p3.contains(misael));
        System.out.println(p3.contains(1));
    }

    private static void test0(){
        System.out.println("+++String Sets+++");

        String[] strings1 = new String[]{"A", "AB", "B"};
        Conjunto<String> set1 = new Conjunto<String>(strings1);

        Collection<String> strings2 = new ArrayList<>();
        strings2.add("A");
        strings2.add("AB");
        strings2.add("C");
        strings2.add("CD");
        strings2.add("D");
        strings2.add("E");
        Conjunto<String> set2 = new Conjunto<>(strings2);

        Conjunto<String> set3 = new Conjunto<>();
        set3.add("CD");
        set3.add("D");

        Conjunto<String> set4 = new Conjunto<>();
        set4.add("A");
        set4.add("AB");
        set4.add("B");
        set4.add("C");
        set4.add("CD");
        set4.add("D");
        set4.add("E");
        set4.add("F");
        set4.add("FG");
        set4.add("G");
        set4.add("H");

        set1.print("set1");
        set2.print("set2");
        set3.print("set3");
        set4.print("Universo String");

        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();

        System.out.println("+++Int Sets+++");

        Conjunto<Integer> set5 = new Conjunto<>();
        set5.add(1);
        set5.add(2);
        set5.add(4);

        Conjunto<Integer> set6 = new Conjunto<>();
        set6.add(3);
        set6.add(5);
        set6.add(8);

        Conjunto<Integer> set7 = new Conjunto<>();

        for (int i = 0; i <= 20; i++) {
            set7.add(i);
        }

        set5.print("set5");
        set6.print("set6");
        set7.print("Universe Int");

        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();

        String A = "A";
        String BC = "BC";
        System.out.println("\"A\" ∈ set2 : " + set2.contains(A));
        System.out.println("\"BC\" ∈ set2 : " + set2.contains(BC));
        System.out.println("|set2| : " + set2.size());

        set2.union(set1).print("set2 ⋃ set1");
        set2.intersection(set1).print("set2 ⋂ set1");
        set2.difference(set1).print("set2 - set1");

        System.out.println("set2 ⊆ set3 : " + set2.subsetP(set3));
        System.out.println("set3 ⊆ set2 : " + set3.subsetP(set2));
        System.out.println("set3 ⊆ set3 : " + set3.subsetP(set3));
        System.out.println("set3 ⊂ set3 : " + set3.subset(set3));

        set1.productC(set2).print("set1 x set2");
        set1.productC(set5).print("set1 x set5");
        set5.productC(set1).print("set5 x set1");
        set2.complement(set4).print("complement set2");
        set5.complement(set7).print("complement set5");

        set1.pow().print("set1 pow");

        var clonedSet = set1.clone();
        clonedSet.print("Cloned Set1");
    }

}
