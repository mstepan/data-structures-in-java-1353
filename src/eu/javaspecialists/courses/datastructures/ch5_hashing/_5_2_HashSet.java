package eu.javaspecialists.courses.datastructures.ch5_hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * hashCode() vs identityHashCode()
 * Pixel and good hash code
 * Bucket collisions
 * Making keys implement Comparable <-- very IMPORTANT in new java versions
 */
public class _5_2_HashSet {

    public static void main(String... args) {
        final int xMax = 1920;
        final int yMax = 1080;

        List<Pixel> pixels = new ArrayList<>();
        for (int x = 0; x < xMax; x++) {
            for (int y = 0; y < yMax; y++) {
                pixels.add(new Pixel(x, y));
            }
        }


        final long distinct = pixels.stream().map(Pixel::hashCode).
            distinct().
            count();
        final int total = xMax * yMax;
        double percentage = (distinct * 100.0) / total;

        System.out.printf("uniqueHashCodes: %.2f %%%n", percentage);

        /*
         * Without Comparable to Student:
         *
         * time to create HashSet: 504 ms
         * time to call contains: 492 ms
         *
         * With Comparable for Student:
         *
         * time to create HashSet: 261 ms
         * time to call contains: 122 ms
         */
        for (int i = 0; i < 5; i++) {
            System.out.println("=========================");
            test(pixels);
        }
    }

    private static void test(List<Pixel> pixels) {
        Set<Pixel> pixelsSet;

        long createTime = System.nanoTime();
        try {
            pixelsSet = new HashSet<>(pixels);
        }
        finally {
            createTime = System.nanoTime() - createTime;
            System.out.printf("time to create HashSet: %d ms%n", (createTime / 1_000_000));
        }

        long containsTime = System.nanoTime();
        try {
            for (Pixel singlePixel : pixels) {
                if (!pixelsSet.contains(singlePixel)) {
                    throw new AssertionError();
                }
            }
        }
        finally {
            containsTime = System.nanoTime() - containsTime;
            System.out.printf("time to call contains: %d ms%n", (containsTime / 1_000_000));
        }
    }

    public static record Pixel(int x, int y) implements Comparable<Pixel> {

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pixel pixel = (Pixel) o;

            if (x != pixel.x) {
                return false;
            }
            return y == pixel.y;
        }

        @Override
        public int hashCode() {
//            int result = x;
//            result = 31 * result + y;
//            return result;
//            return (x << 16) | y ;
            return y * 1920 + x; // super fast hashCode
        }

        @Override
        public int compareTo(Pixel other) {
            int cmp = Integer.compare(x, other.x);
            if (cmp != 0) {
                return cmp;
            }
            return Integer.compare(y, other.y);
        }
    }

}
