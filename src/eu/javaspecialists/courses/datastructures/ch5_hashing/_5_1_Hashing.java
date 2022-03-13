package eu.javaspecialists.courses.datastructures.ch5_hashing;

import java.util.HashSet;

/**
 * Writing very basic hashtable
 * Clashes and distribution
 * % vs &
 */
public class _5_1_Hashing {

    public static void main(String... args) {

        var data = new HashSet<Student>();
        data.add(new Student("Maksym", 11));

        System.out.println(data.contains(new Student("Maksym", 11)));
    }

}
