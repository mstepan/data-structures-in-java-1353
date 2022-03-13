package eu.javaspecialists.courses.datastructures.ch3_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Sorting performance ArrayList vs LinkedList
 * Parallel sorting of ArrayList
 */
public class _3_4_ParallelSorting {

    public static void main(String... args) {

        List<Integer> data =
            ThreadLocalRandom.current().ints(10_000_000).
                parallel().
                boxed().
                collect(Collectors.toList());

        long time = System.nanoTime();
        try {
//            Collections.sort(data); // sequential sort, 5087ms for 10M
            parallelSort(data, null); // parallel sort, 1816ms for 10M
        }
        finally {
            time = System.nanoTime() - time;
            System.out.printf("time: %dms%n", (time / 1_000_000));
        }

        System.out.println(data.size());
//        System.out.println(data);

    }

    // copied directly from List.sort()
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <E> void parallelSort(List<E> listToSort, Comparator<? super E> comparator) {
        Object[] a = listToSort.toArray();
        Arrays.parallelSort(a, (Comparator)comparator);
        ListIterator<E> i = listToSort.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }
}
