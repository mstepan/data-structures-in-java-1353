package eu.javaspecialists.courses.datastructures.ch6_maps;

import java.util.HashMap;
import java.util.Map;

/**
 * one-to-one dictionary
 */
public class _6_1_Maps {

    public static void main(String... args) {

        Map<String, String> map = new HashMap<>();
        map.put("a", "First");

        String key = new String("a");
        map.put(key, "Second");

        System.out.println(map);

        for (String keyFromMap : map.keySet()) {
            if (keyFromMap.equals(key)) {
                System.out.println(keyFromMap == key);
            }
        }

    }
}
