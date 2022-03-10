package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Adding four seasons
 * indexOf() and contains()
 * size() vs elementData.length in debugger
 * removeIf()
 */
public class _2_2_ArrayList {

    public static void main(String... args) {
//        List<Integer> numbers = IntStream.range(0, 10_000).
//            boxed().
//            collect(Collectors.toCollection(ArrayList::new));
//
//        List<Integer> cow = new CopyOnWriteArrayList<>(numbers);
//
//        var list = new ArrayList<String>();
//        list.add("hello");// array length = 10
//        // growth by 50% when over capacity
//
//        var data = new ArrayList<Integer>(10_000);
//
//        // 10 * 1.5 * 1.5 * .... >= 10_000 = 14053
//        for (int i = 0; i < 10_000; ++i) {
//            data.add(i);
//        }
//        data.trimToSize();

        // removeIf
        long time = System.nanoTime();

        List<Integer> oddNumbers = IntStream.range(0, 1_000_000).
            boxed().
            collect(Collectors.toCollection(ArrayList::new));

        oddNumbers.removeIf(value -> (value & 1) == 0);

        // O(N^2)
//       for(Iterator<Integer> it = oddNumbers.iterator(); it.hasNext(); ){
//           Integer value = it.next();
//
//           if( (value & 1) == 0 ){
//               it.remove();
//           }
//       }

        time = System.nanoTime() - time;

        System.out.printf("time: %d ms%n", (time / 1_000_000));
    }
}
