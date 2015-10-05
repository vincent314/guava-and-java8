package org.vince.guava;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Step3Java8 {

    @Test
    public void testFilter() {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Conserver les nombres pairs
        int[] result = Arrays.stream(values)
            .filter((i) -> i % 2 == 0)
            .toArray();

        assertArrayEquals(new int[]{2, 4, 6, 8, 10}, result);
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
        List<String> prenoms = Arrays.asList("Ghislaine", "Catherine");

        List<User> users = prenoms.stream()
            .map((prenom) -> {
                System.out.println("Traitement de " + prenom);
                return new User(prenom);
            })
            .collect(Collectors.toList());

        // result est une collection lazy
        System.out.println("COLLECTION NOT LAZY");

        Assert.assertArrayEquals(
            new User[]{
                new User("Ghislaine"),
                new User("Catherine")
            },
            users.toArray()
        );
    }

    @Test
    public void testChain() {
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String result = Stream.of(values)
            .filter((i) -> i % 2 == 0)
            .map((i) -> Integer.toString(i))
            .collect(Collectors.joining(";"));

        assertEquals("2;4;6;8;10", result);
    }
}
