package Helpers;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Class for reverse of {@link List}.
 * Implementing custom iterator {@link Reversed#iterator()}
 * and
 * method {@link Reversed#reversed(List)} for return reverse list
 */
public class Reversed<T> implements Iterable<T> {
    private final List<T> orig;

    private Reversed(List<T> orig) {
        this.orig = orig;
    }

    public Iterator<T> iterator() {
        final ListIterator<T> i = orig.listIterator(orig.size());
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return i.hasPrevious();
            }

            @Override
            public T next() {
                return i.previous();
            }

        };
    }
    public static <T> Reversed<T> reversed(List<T> orig){
        return new Reversed<>(orig);
    }
}
