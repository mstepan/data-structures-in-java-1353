package eu.javaspecialists.courses.datastructures.ch4_sets;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Sorted by natural order
 * Red-black tree
 * Unbalanced tree O(n) vs O(log n)
 * Counting maximum tree depth
 */
public class _4_2_TreeSet {

    public static void main(String... args) {
        // log2(1_000_000) ~ 20

        Set<Integer> data = new TreeSet<>();

        for (int i = 0; i < 1_000_000; i++) {
            data.add(i);
        }

        System.out.println(calculateTreeHeight(data)); // return 37, so no more than 2 * log2(1_000_000) = 40

    }

    private static int calculateTreeHeight(Set<Integer> data) {
        try {
            Field mFiled = data.getClass().getDeclaredField("m");
            mFiled.setAccessible(true);
            TreeMap<Integer, Object> treeMap = (TreeMap) mFiled.get(data);

            Field rootField = treeMap.getClass().getDeclaredField("root");
            rootField.setAccessible(true);
            Map.Entry<Integer, Object> rootNode = (Map.Entry) rootField.get(treeMap);
            return findDepthRec(rootNode);
        }
        catch (Exception ex) {
            return -1;
        }
    }

    private static int findDepthRec(Map.Entry<Integer, Object> node) throws Exception {
        if (node == null) {
            return 0;
        }
        /*
        Entry<K,V> left;
        Entry<K,V> right;
         */
        Field leftField = node.getClass().getDeclaredField("left");
        leftField.setAccessible(true);
        Map.Entry<Integer, Object> leftNode = (Map.Entry) leftField.get(node);

        Field rightField = node.getClass().getDeclaredField("right");
        rightField.setAccessible(true);
        Map.Entry<Integer, Object> rightNode = (Map.Entry) rightField.get(node);

        return 1 + Math.max(findDepthRec(leftNode), findDepthRec(rightNode));

    }
}
