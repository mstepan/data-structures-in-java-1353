package eu.javaspecialists.courses.datastructures.ch6_maps;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap and LinkedHashSet
 */
public class _6_7_LinkedHashMapAndSet {

    public static void main(String... args) {
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("three", 3);
        map.put("one", 1);
        map.put("two", 2);

        map.forEach((key, val) -> System.out.println(key));
    }
}
