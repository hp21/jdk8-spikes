package org.hp.jdk8;

import java.time.Clock;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {

        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

        integers.forEach(p -> System.out.println(p));

        System.out.println("================  Consumer ==================");

        Consumer<Integer> q = (Integer z) -> {
            System.out.println(z);
        };

        integers.forEach(q);

        System.out.println("================  Consumer 1 ==================");

        List<Integer> myIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        final long count = myIntegers.stream().count();
        System.out.println("count=" + count);

        System.out.println("================  Consumer 2 ==================");

        myIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        final Stream<Integer> sorted = myIntegers.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });

        sorted.forEach(x -> System.out.print(x + ", "));
        System.out.println();
        myIntegers.forEach(x -> System.out.print(x + ", "));
        System.out.println();

        System.out.println("================  Consumer 3 ==================");

        myIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        final Stream<Integer> sorted1 = myIntegers.stream().sorted((a, b) -> a.compareTo(b));

        sorted1.forEach(x -> System.out.print(x + ", "));

        final Integer[] integers1 = new Integer[100000];

        final Random random = new Random(63294503);

        IntStream intsToSort = random.ints(100000000, 0, 999999);

        final long start1 = System.currentTimeMillis();
        final IntStream sorted2 = intsToSort.sorted();
        final long end1 = System.currentTimeMillis();

        final long start2 = System.currentTimeMillis();
//        final IntStream sorted3 = intsToSort.parallel().sorted();
        final long end2 = System.currentTimeMillis();

        System.out.println(" 1: " + (end1 - start1) + " ms");
        System.out.println(" 1: " + (end2 - start2) + " ms");

    }
}
