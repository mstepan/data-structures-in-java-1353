package eu.javaspecialists.courses.datastructures.ch4_sets;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.IntStream;

/**
 * Thread-safe sorted set
 */
public class _4_3_ConcurrentSkipListSet {

    public static void main(String... args) {
        Set<Integer> data = new ConcurrentSkipListSet<>();
        IntStream.range(0, 10_000).
            parallel().
            forEach(data::add);

        System.out.println(data.size());
    }
}
