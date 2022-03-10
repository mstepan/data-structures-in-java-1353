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
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Max", "Zorro", "Olesia");

        Collections.rotate(names, 1);

        System.out.println(names);


        names.sort(null);

        System.out.println(names);
    }

    static class Student {
        final String name;
        final int age;

        public static Comparator<Student> NAME_THEN_AGE_DESC = Comparator.comparing(Student::getName).
            thenComparing(Student::getAge, Comparator.reverseOrder());

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Student(String name, int age) {


            this.name = name;
            this.age = age;
        }
    }
}
