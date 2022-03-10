package eu.javaspecialists.courses.datastructures.ch5_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * hashCode() vs identityHashCode()
 * Pixel and good hash code
 * Bucket collisions
 * Making keys implement Comparable
 */
public class _5_2_HashSet {
    public static void main(String... args) {

        Set<Pixel> data = new HashSet<>();
        data.add(new Pixel(1, 2));

        System.out.println(data);

    }

    record Pixel(int x, int y) {

    }
}
