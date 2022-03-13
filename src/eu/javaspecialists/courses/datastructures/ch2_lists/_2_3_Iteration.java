package eu.javaspecialists.courses.datastructures.ch2_lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Enumeration bugs
 * Fail fast collection
 * forEach()
 * <p>
 * There are 3 types of iterators:
 * 1. fail-fast iterator (ArrayList and other collections, also include Vector)
 * 2. snapshot iterator (CopyOnWriteArrayList)
 * 3. weak-consistency iterator (all lock-free concurrent collections ConcurrentLinkedQueue)
 * 4. Enumeration java 1.0
 */
public class _2_3_Iteration {
    public static void main(String... args) {

        Collection<String> beachToys = new ConcurrentLinkedQueue<>();
        Collections.addAll(beachToys, "floatie", "sunblock", "rage", "razor",
                           "umbrella", "bucket", "raki");


//        enumeratorBroken(beachToys); // will delete some elemnt, but will left other, so not working
//        enumerationFixed(beachToys); // works fine for Enumeration

//        failFastIteratorBroken(beachToys); // ConcurrentModificationException
//        failFastIteratorFixed(beachToys);

//        snapshotOrWeakConsistenIterator(beachToys); // working version

        iterateAndRemove(beachToys); // works for any iterator: fail-fast, snapshot, weakly-consistent

        System.out.println(beachToys);
    }

    private static void iterateAndRemove(Collection<String> data){
        data.removeIf(value -> value.startsWith("ra"));
    }

    private static void snapshotOrWeakConsistenIterator(Collection<String> data) {
        for (Iterator<String> it = data.iterator(); it.hasNext(); ) {
            String value = it.next();
            if( value.startsWith("ra") ){
                data.remove(value);
            }
        }
    }

    private static void failFastIteratorBroken(Collection<String> data) {
        for (Iterator<String> it = data.iterator(); it.hasNext(); ) {
            String value = it.next();
            if( value.startsWith("ra") ){
                data.remove(value);
            }
        }
    }

    private static void failFastIteratorFixed(Collection<String> data) {
        for (Iterator<String> it = data.iterator(); it.hasNext(); ) {
            String value = it.next();
            if( value.startsWith("ra") ){
                it.remove();
            }
        }

    }

    private static void enumerationBroken(Vector<String> data) {

        Enumeration<String> it = data.elements();

        while (it.hasMoreElements()) {
            String value = it.nextElement();
            if (value.startsWith("ra")) {
                data.remove(value);
            }
        }
    }

    private static void enumerationFixed(Vector<String> data) {

        List<String> toRemove = new ArrayList<>();
        Enumeration<String> it = data.elements();

        while (it.hasMoreElements()) {
            String value = it.nextElement();
            if (value.startsWith("ra")) {
                toRemove.add(value);
            }
        }
        data.removeAll(toRemove);
    }
}
