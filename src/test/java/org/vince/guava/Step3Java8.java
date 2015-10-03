package org.vince.guava;

import com.google.common.collect.Iterables;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by vincent on 01/10/15.
 */
public class Step3Java8 {

    @Test
    public void testFilter() {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Conserver les nombres pairs
        IntStream result = Arrays.stream(values)
            .filter((i) -> i % 2 == 0)
            .collect(Collectors::toList);

        assertTrue(
            Iterables.elementsEqual(
                Arrays.asList(2, 4, 6, 8, 10),
                result
            ));
    }

    class User {
        String prenom;

        public User(String prenom) {
            this.prenom = prenom;
        }

        @Override
        public boolean equals(Object obj) {
            return prenom.equals(((User) obj).prenom);
        }
    }


    @Test
    public void testTransform() {
        List<String> values = Arrays.asList("Ghislaine", "Catherine");

        List<User> result = Lists.transform(values, new Function<String, User>() {

            @Override
            public User apply(String prenom) {
                System.out.println("Traitement de " + prenom);
                return new User(prenom);
            }
        });

        // result est une collection lazy
        System.out.println("LAZY COLLECTION !!!");

        assertTrue(
            Iterables.elementsEqual(
                Arrays.asList(
                    new User("Ghislaine"),
                    new User("Catherine")
                ),
                result
            ));
    }

    @Test
    public void testChain() {
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        String result = FluentIterable.of(values)
            .filter(new Predicate<Integer>() {
                @Override
                public boolean apply(Integer i) {
                    return i % 2 == 0;
                }
            })
            .join(Joiner.on(";"));

        assertEquals("2;4;6;8;10", result);
    }
}
