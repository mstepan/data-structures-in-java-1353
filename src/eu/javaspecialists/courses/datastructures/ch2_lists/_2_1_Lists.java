package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Do not use Arrays.asList(), use List.of()
 * RandomAccess
 */
public class _2_1_Lists {
    public static void main(String... args) {

        // Do not use Arrays.asList(), use List.of()
        String[] arr = new String[] {"Maksym", "Olesia", "Zorro"};

        List<String> data = List.of(arr);

        arr[0] = "Maksym-123";

        System.out.println(data);

        RandomAccess[] lists = {
            new ArrayList<>(),
            new CopyOnWriteArrayList<>(),
            new Vector<>(),
        };

        List<Integer> temp = new ArrayList<>();
        temp.spliterator();

    }
}
