package eu.javaspecialists.courses.datastructures.ch1_introduction;

/**
 * Computational Time and Space Complexity
 * O(1), O(n), O(n^2^), O(log n), O(n * log n)
 */
public class _1_1_ComputationalTimeComplexity {

    public static void main(String... args) {
        //O(1) constant time ArrayList().size()
        // O(n) linear time, ConcurrentLinkedQueue.size()
        // O(N^2) quadratic time, CopyOnWriteArrayList.addAll()
        // O(lgN) logarithmic, Array.binarySearch(), new TreeSet().add()
        // O(n*lgN) quasilinear, Arrays.sort()

        long start = System.nanoTime();

//        add(10_000);

        long end = System.nanoTime();

        System.out.printf("time: %d ms%n", ((end - start) / 1_000_000));
    }

    /*
    2x => 4x
    10K => 172 ms
    20K => 345 ms (2 x)
    40K => 947 ms (2.7 x)
    80K => 3477 ms (3.6 x)
    160K => 12812 ms (3.7 x)
    320K => 56010 ms (4.3 x)
    640K => 303607 ms (5.4 x)
     */
    public static String add(int n) {
        String res = "";
        for (int i = 0; i < n; ++i) {
            res += ("i = " + i);
        }
        return res;
    }
}
