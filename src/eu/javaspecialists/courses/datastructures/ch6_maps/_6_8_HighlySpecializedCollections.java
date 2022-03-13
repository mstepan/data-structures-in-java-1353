package eu.javaspecialists.courses.datastructures.ch6_maps;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * EnumSet
 * EnumMap
 * IdentityHashMap
 * Properties
 * WeakHashMap
 */
public class _6_8_HighlySpecializedCollections {

    public static void main(String... args) {
        Map<String, Integer> map = new IdentityHashMap<>();
        map.put("one", 1);
        map.put(new String("one"), 111);

        System.out.println(map);
    }
}
