package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Safe iteration
 * use-cases: small list that doesn't change often
 */
public class _2_4_CopyOnWriteArrayList {

    public static void main(String... args) {
        var list = new CopyOnWriteArrayList<Integer>();

//        var list = new Vector<Integer>();

//        long time = addToListSlow(list, 100_000);
        long time = addToListFast(list, 100_000);

        System.out.printf("time: %dms%n", (time / 1_000_000));
        System.out.println(list.size());
    }

    // time: O(N)
    private static long addToListFast(List<Integer> list, int count) {
        long time = System.nanoTime();

        var temp = new ArrayList<Integer>(count);
        for (int i = 0; i < count; i++) {
            temp.add(i);
        }
        list.addAll(temp);
        time = System.nanoTime() - time;
        return time;
    }


    // time: O(N^2)
    private static long addToListSlow(List<Integer> list, int count) {
        long time = System.nanoTime();

        for (int i = 0; i < count; ++i) {
            list.add(i);
        }
        time = System.nanoTime() - time;
        return time;
    }
}
