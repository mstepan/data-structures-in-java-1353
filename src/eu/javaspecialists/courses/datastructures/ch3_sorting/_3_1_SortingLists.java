package eu.javaspecialists.courses.datastructures.ch3_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorting list of Strings
 * Sorting custom classes like Student
 * Comparing ints and longs
 */
public class _3_1_SortingLists {

    public static void main(String... args) {
        List<Student> names = new ArrayList<>();
        Collections.addAll(names, new Student("Max", 36), new Student("Zorro", 250), new Student("Olesia", 36),
                           new Student("Zorro", 99), new Student("Kostia", 16), new Student("Zorro", 150));

        Collections.reverse(names);
        Collections.shuffle(names);
        Collections.rotate(names, 1);

        names.sort(Student.NAME_THEN_AGE_DESC);
        System.out.println(names);

//        Collections.rotate(names, 1);
//        System.out.println(names);
    }

    record Student(String name, int age) implements Comparable<Student> {

        public static Comparator<Student> NAME_THEN_AGE_DESC = Comparator.comparing(Student::name).
            thenComparing(Student::age, Comparator.reverseOrder());

        public static Comparator<Student> NAME_THEN_AGE = Comparator.comparing(Student::name).
            thenComparing(Student::age);

        @Override
        public int compareTo(Student other) {
            return NAME_THEN_AGE.compare(this, other);
        }

        @Override
        public String toString() {
            return "(" + name + ", " + age + ")";
        }
    }
}
