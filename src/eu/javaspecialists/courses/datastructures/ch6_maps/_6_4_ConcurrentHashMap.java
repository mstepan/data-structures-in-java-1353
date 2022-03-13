package eu.javaspecialists.courses.datastructures.ch6_maps;

import static eu.javaspecialists.courses.datastructures.ch5_hashing._5_2_HashSet.Pixel;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.IntStream;

/**
 * Always use
 * Compound operations review
 */
public class _6_4_ConcurrentHashMap {
    public static void main(String... args) {

      /*
       * HashMap => time: 1438 ms
       * ConcurrentHashMap => time: 1900 ms
       * ConcurrentSkipListMap => time: 15484 ms
       * Hashtable => long time
       * Collections.synchronizedMap(new HashMap<>()) => long time
       */
        Map<Pixel, Integer> map = new ConcurrentHashMap<>();
        Collection<Pixel> pixelsList = new ConcurrentLinkedQueue<>();

        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                var pixel = new Pixel(x, y);
                pixelsList.add(pixel);
                map.put(pixel, pixel.hashCode());
            }
        }

        long time = System.nanoTime();
        try {
            IntStream.range(0, Runtime.getRuntime().availableProcessors()).
                parallel().
                forEach(thId -> {
                    for (int iteration = 0; iteration < 10_000; iteration++) {
                        for (Pixel curPixel : pixelsList) {
                            map.get(curPixel);
                        }
                    }

                });
        }
        finally {
            time = System.nanoTime() - time;
            System.out.printf("time: %d ms%n", (time / 1_000_000));
        }
    }
}
