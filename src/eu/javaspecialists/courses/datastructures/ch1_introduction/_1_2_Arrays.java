package eu.javaspecialists.courses.datastructures.ch1_introduction;

import java.util.ArrayList;

/**
 * Primitive vs object arrays
 * Multi-dimensional arrays
 */
public class _1_2_Arrays {
  public static void main(String... args) {
    int[] arr = new int[1000]; // 4000 + 16 ~ 4KB
    var list = new ArrayList<>(); // (16 * 1000) + 4000 +  24 ~ 20 KB
    // each Integer is 16 bytes, so we have 16 * 1000 just to store Integers
    // array of Integer pointers 4 bytes * 1000
    // and ArrayList class overhead 24 bytes
  }
}
