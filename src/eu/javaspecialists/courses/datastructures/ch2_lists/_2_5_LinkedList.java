package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Node memory usage
 * Accessing middle of list
 */
public class _2_5_LinkedList {

    public static void main(String... args) {

        List<Integer> data = IntStream.range(1, 10_000).
            boxed().collect(Collectors.toCollection(LinkedList::new));

    }
}
