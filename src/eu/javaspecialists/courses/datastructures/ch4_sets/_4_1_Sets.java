package eu.javaspecialists.courses.datastructures.ch4_sets;

import java.util.Set;

/**
 * Set.of(),
 * union with addAll()
 * intersection with retainAll() or stream/filter
 */
public class _4_1_Sets {
    public static void main(String... args) {

        // Set.of(1, 2, 3, 1);  <-- IllegalArgumentException: duplicate element: 1

        Set<Integer> data = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(data);
    }
}
