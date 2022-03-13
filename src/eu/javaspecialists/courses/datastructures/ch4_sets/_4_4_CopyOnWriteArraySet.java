package eu.javaspecialists.courses.datastructures.ch4_sets;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * For very small sets
 */
public class _4_4_CopyOnWriteArraySet {

    public static void main(String... args) {
        MyObservable model = new MyObservable();

        model.addObserver(new MyObserver1());
        model.addObserver(new MyObserver1());

        model.notifyObservers("change-123");
    }

    static class MyObserver1 implements MyObserver {
        @Override
        public void update(MyObservable obsModel, Object arg) {
            System.out.println("Observer2: " + arg);
        }
    }

    @FunctionalInterface
    interface MyObserver {
        void update(MyObservable obsModel, Object arg);
    }

    static class MyObservable {

        private final Set<MyObserver> obs = new CopyOnWriteArraySet<>();

        public void addObserver(MyObserver o) {
            if (o == null) {
                throw new NullPointerException();
            }
            obs.add(o);
        }

        public void notifyObservers(Object arg) {
            for (MyObserver singleObserver : obs) {
                singleObserver.update(this, arg);
            }
        }

        public void deleteObservers() {
            obs.clear();
        }

    }
}





