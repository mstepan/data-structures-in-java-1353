package eu.javaspecialists.courses.datastructures.ch3_sorting;

import java.util.Arrays;
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
            ThreadLocalRandom.current().ints(10).boxed().parallel().collect(Collectors.toList());

//        Collections.sort(data);
        parallelSort(data);

        System.out.println(data);

    }

    static <E> void parallelSort(List<E> c) {
        Object[] a = c.toArray();
        Arrays.parallelSort(a, null);
        ListIterator<E> i = c.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }
}
