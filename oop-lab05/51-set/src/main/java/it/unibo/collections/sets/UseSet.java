package it.unibo.collections.sets;

//import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * Example class using {@link java.util.Set}.
 *
 */
public final class UseSet {

    private static final int ELEMS = 20;

    private UseSet() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        /*
         * Considering the content of "UseCollection, write a program which, in
         * order:
         *
         * 1) Builds a TreeSet containing Strings
         */
        /*
         * 2) Populates such Collection with all the Strings representing numbers ranging from "1" to
         * "20" (both included)
         */
        /*
         * 3) Prints its content
         */
        /*
         * 4) Removes all those strings whose represented number is divisible by three.
         * Note: the method removeIf(Predicate) is not allowed.
         */
        /*
         * 5) Prints the content of the Set using a for-each construct
         */
        /*
         * 6) Verifies whether all the numbers left in the set are even
         */
        final Set<String> set = new TreeSet<>();
        for (int i = 1; i <= ELEMS; i++) {
            set.add(String.valueOf(i));
        }
        System.out.println(set);
        set.removeIf(value -> Integer.parseInt(value) % 3 == 0);
        for (final String s : set){
            System.out.print(s + " ");
        }
        System.out.println();
        boolean allEven = true;
        for (final String s : set) {
            if (Integer.parseInt(s) % 2 != 0) {
                allEven = false;
                break;
            }
        }
        System.out.println("All numbers are even? " + allEven);
    }
}
