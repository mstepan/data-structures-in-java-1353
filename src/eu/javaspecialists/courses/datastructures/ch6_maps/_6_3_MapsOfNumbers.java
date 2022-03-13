package eu.javaspecialists.courses.datastructures.ch6_maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Creating maps of numbers
 * computeIfAbsent() for List of values
 * computeIfAbsent() is atomic operation inside ConcurrentHashMap
 */
public class _6_3_MapsOfNumbers {

    private static final Map<Integer, Long> squaresCache = new ConcurrentHashMap<>();

    public static long getSquare(int value) {
        return squaresCache.computeIfAbsent(value, (key) -> (long) (key * key));
    }

    public static void main(String... args) {
        Map<String, Integer> numbersToInts = Map.of(
            "one", 1,
            "two", 2,
            "un", 1,
            "duo", 2,
            "tres", 3
        );

        Map<Integer, List<String>> numberToListOfNames = new HashMap<>();

        for (var entry : numbersToInts.entrySet()) {
            numberToListOfNames.computeIfAbsent(entry.getValue(), __ -> new ArrayList<>()).
                add(entry.getKey());
        }

        System.out.println(numberToListOfNames);
    }
}
