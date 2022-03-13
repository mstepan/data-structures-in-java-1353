package eu.javaspecialists.courses.datastructures.ch5_hashing;

import java.util.Objects;

public final class Student {

    final String name;
    final int iq;

    public Student(String name, int iq) {
        this.name = name;
        this.iq = iq;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student other)) {
            return false;
        }
        return Objects.equals(name, other.name) && Objects.equals(iq, other.iq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, iq);
    }

    @Override
    public String toString() {
        return "(" + name + ", " + iq + ")";
    }
}
