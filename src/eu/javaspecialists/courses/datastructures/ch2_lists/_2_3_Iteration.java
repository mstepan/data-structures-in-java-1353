package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.*;

/**
 * Enumeration bugs
 * Fail fast collection
 * forEach()
 *
 * There are 3 types of iterators:
 * 1. fail-fast iterator (ArrayList and other collections, also include Vector)
 * 2. snapshot iterator (CopyOnWriteArrayList)
 * 3. weak-consistency iterator (all lock-free concurrent collections ConcurrentLinkedQueue)
 */
public class _2_3_Iteration {
    public static void main(String... args) {
        Vector<String> beachToys = new Vector<>();
        Collections.addAll(beachToys, "floatie", "sunblock", "rage", "razor",
                           "umbrella", "bucket", "raki");
    }
}
